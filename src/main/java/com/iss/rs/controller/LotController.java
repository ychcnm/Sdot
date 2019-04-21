package com.iss.rs.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iss.rs.domain.*;
import com.iss.rs.entity.Lot;
import com.iss.rs.entity.Oven;
import com.iss.rs.entity.Productinfo;
import com.iss.rs.service.LotService;
import com.iss.rs.service.OvenService;
import com.iss.rs.service.ProductService;
import com.iss.rs.util.ListGenerator;
import com.opencsv.CSVReader;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/lot")
public class LotController {
    public static final String SOLVER_CONFIG
            = "solver/lotSchedulingSolverConfig.xml";
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(LotController.class);
    private static final String UPLOAD_FILE_SAVE_FOLDER = "/UPLOAD/";
    @Autowired
    ServletContext context;
    @Resource(name = "ProductService")
    private ProductService productService;
    @Resource(name = "OvenService")
    private OvenService ovenService;
    @Resource(name = "LotService")
    private LotService lotService;

    @Autowired
    private HttpServletRequest httpRequest;

    //映射一个action
    @RequestMapping("/choosePlan")
    public String choosePlan() throws Exception {
        //输出日志文件
        logger.info("the choose jsp pages");
        //返回一个index.jsp这个视图
        return "choosePlan";
    }

    @RequestMapping(value = "/lotPlan", method = RequestMethod.GET)
    public String planLotPage() {

        //跳转至首页
        return "lotPlan";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadLotPage() {

        //跳转至首页
        return "uploadLot";
    }

    //映射一个action
    @RequestMapping(value = "/getProduct.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, List<String>> getProduct() throws Exception {
        //输出日志文件
        logger.info("/getProduct.do");
        List<Productinfo> product = productService.getAllProduct();
        Map<String, List<String>> resultMap = new HashMap<>();
        product.stream().forEach(p -> {
            String head = p.getProductType().substring(0, 1);
            if (resultMap.containsKey(head)) {
                List<String> list = resultMap.get(head);
                list.add(p.getProductType());
                resultMap.put(head, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(p.getProductType());
                resultMap.put(head, list);
            }
        });
        return resultMap;
    }

    @RequestMapping(value = "/getProductType.do", produces = "application/json")
    @ResponseBody
    public List<String> getProductType(@RequestBody String data) throws Exception {
        //输出日志文件
        logger.info("/getProductType.do");
        Gson gson = new Gson();
        String series = gson.fromJson(data, JsonObject.class).get("series").getAsString();
        System.out.println(series);
        List<String> productType = productService.getProductType(series);
        return productType;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    String delete(HttpServletRequest request) {
        String fileName = request.getParameter("file");
        String destFilePath = UPLOAD_FILE_SAVE_FOLDER + fileName;
        String realPathtoUploads = httpRequest.getSession().getServletContext().getRealPath(destFilePath);
        //Delete the file
        try {
            Files.delete(Paths.get(realPathtoUploads));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        return "Success";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
        Iterator<String> itr = request.getFileNames();
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        try {
            StringBuffer msgBuf = new StringBuffer();

            // Get multiple file control names.
            Iterator<String> it = request.getFileNames();

            while (it.hasNext()) {
                String fileControlName = it.next();

                MultipartFile srcFile = request.getFile(fileControlName);

                String uploadFileName = srcFile.getOriginalFilename();

                // Create server side target file path.
                String destFilePath = UPLOAD_FILE_SAVE_FOLDER + uploadFileName;
                String realPathtoUploads = httpRequest.getSession().getServletContext().getRealPath(destFilePath);

                File destFile = new File(realPathtoUploads);

                BufferedWriter w = Files.newBufferedWriter(Paths.get(realPathtoUploads));
                w.write(new String(srcFile.getBytes()));
                w.flush();
                map.put("Status", 200);
                map.put("Success file uploaded List", list);
                return map;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            map.put("Status", 500);
            map.put("fail file uploaded List", list);
            return map;
        }
        return map;
    }

    @RequestMapping(value = "/uploadSubmit", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> uploadSubmit(MultipartHttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<>();
        Iterator<String> itr = request.getFileNames();
        String time = request.getParameter("timeRange");
        String[] dateArray = time.split("-");
        String[] startDay = dateArray[0].trim().split("/");
        String[] endDay = dateArray[1].trim().split("/");

        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(startDay[2]), Integer.parseInt(startDay[0]) - 1, Integer.parseInt(startDay[1]));
        int start = c.get(Calendar.DAY_OF_YEAR);
        c.set(Integer.parseInt(endDay[2]), Integer.parseInt(endDay[0]) - 1, Integer.parseInt(endDay[1]));
        int end = c.get(Calendar.DAY_OF_YEAR);

        String returnStartDate = startDay[2] + "-" + startDay[0] + "-" + startDay[1] + " 00:00";
        String returnEndDate = endDay[2] + "-" + endDay[0] + "-" + endDay[1] + " 23:59";

        List<Lot> lotList = new ArrayList<>();

        while (itr.hasNext()) {
            String fileControlName = itr.next();
            String uploadFileName = request.getFile(fileControlName).getOriginalFilename();

            // Create server side target file path.
            String destFilePath = UPLOAD_FILE_SAVE_FOLDER + uploadFileName;
            String realPathtoUploads = httpRequest.getSession().getServletContext().getRealPath(destFilePath);

            try {
                FileReader filereader = new FileReader(realPathtoUploads);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                csvReader.readNext();
                int lotId = 0;
                while ((nextRecord = csvReader.readNext()) != null) {

                    Productinfo pi = productService.getProductInfo(nextRecord[3]);
                    Integer size = Integer.valueOf(nextRecord[4]);
                    String id = String.valueOf(lotId++);
                    Lot l = new Lot(id, nextRecord[3], pi, size);
                    l.setId((long) (lotId - 1));
                    lotList.add(l);
                }
                //Delete the file
                Files.delete(Paths.get(realPathtoUploads));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ListGenerator listGenerator = new ListGenerator();

        int gap = end - start;
        List<Day> dayList = new ArrayList<>();
        List<TimeGrain> timeGrainList = new ArrayList<>();
        listGenerator.generateTimeList(dayList, timeGrainList, start, gap);

        List<Productinfo> productinfoList = productService.getAllProduct();
        List<Oven> ovenList = ovenService.getAllOven();

        Long ovenId = 0L;
        for (Oven o : ovenList) {
            o.setId(ovenId++);
        }

        List<LotAssignment> lotAssignment = new ArrayList<>();
        Long LPId = 0L;
        List<LotPackage> lotPackagesList = new ArrayList<>();

        listGenerator.generatePackageList(lotList, lotPackagesList, lotAssignment);


        LotSchedule unassignment = new LotSchedule();
        unassignment.setDayList(dayList);
        unassignment.setTimeGrainList(timeGrainList);
        unassignment.setOvenList(ovenList);
        unassignment.setLotList(lotPackagesList);
        unassignment.setLotAssignmentList(lotAssignment);

        unassignment.setId(0L);
        LotConstrainConfiguration constraintConfiguration = new LotConstrainConfiguration();
        constraintConfiguration.setId(0L);
        unassignment.setConstraintConfiguration(constraintConfiguration);

        SolverFactory<LotSchedule> solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        Solver<LotSchedule> solver = solverFactory.buildSolver();

        LotSchedule assigned = solver.solve(unassignment);//启动引擎

        int hardScore = assigned.getScore().getHardScore();
        int softScore = assigned.getScore().getSoftScore();
        int initScore = assigned.getScore().getInitScore();

        HashMap<Oven, List<LotAssignment>> result = new HashMap<>();

        assigned.getLotAssignmentList().stream().forEach(l -> {
            if (result.containsKey(l.getOven())) {
                List<LotAssignment> lp = result.get(l.getOven());
                lp.add(l);
                result.put(l.getOven(), lp);
            } else {
                List<LotAssignment> lp = new ArrayList<>();
                lp.add(l);
                result.put(l.getOven(), lp);
            }
        });
        map.put("Status", 200);
        map.put("resultData", result);
        map.put("HardScore", hardScore);
        map.put("SoftScore", softScore);
        map.put("StartDate", returnStartDate);
        map.put("EndDate", returnEndDate);
        return map;
    }
}
