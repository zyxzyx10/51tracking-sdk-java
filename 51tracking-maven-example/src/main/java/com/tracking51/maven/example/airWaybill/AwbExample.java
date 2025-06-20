package com.tracking51.maven.example.airWaybill;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.airWaybill.AirWaybill;
import com.tracking51.model.airWaybill.AirWaybillParams;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

public class AwbExample {

    @SneakyThrows
    public static void main(String[] args) {
        String csvFile = "output.csv";
        FileWriter writer = new FileWriter(csvFile);
        // 写入表头
        writer.append("tracking number,airline,flight number,from,departure time,arrive,arrive time,status,weight,piece,track url\n");

        String apiKey = "b6ddqpp0-4x36-npl9-3pmj-s7kcr7nsxft0";
        Tracking51 tracking51 = new Tracking51(apiKey);
        AirWaybillParams airWaybillParams = new AirWaybillParams();

//        long tracking = 93193085L;//4月例子
//        long tracking = 93193000L;//4月
//        long tracking = 93192724L;//3月例子
        long tracking = 93192800L;//3月
//        for (int i = 0; i < 20; i++) {
//            System.out.print("160-" + tracking+++",");
//        }


        for (int i = 0; i < 10; i++) {
            String trackings = "160-" + tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking++ + ",160-";
            trackings += tracking + "";

            System.out.println("Searching:" + trackings);
            // 要打开的网址
//            URI url = new URI("https://www.51tracking.com/aircargo/cn/" + trackings);
            URI url = new URI("https://www.track123.com/cn/track?trackNos=" + trackings);
            // 检查系统是否支持 Desktop 类
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(url);
                System.out.println("已在默认浏览器中打开 URL。");
            } else {
                System.out.println("当前系统不支持 Desktop API。");
            }
            Thread.sleep(1000);
            tracking++;
        }


//        try {
//            for (int i = 0; i < 10; i++) {
//                String trackingNuber = "160-" + tracking;
//                System.out.println("Searching:" + trackingNuber);
//                airWaybillParams.setAwbNumber(trackingNuber);
//                Tracking51Response result = tracking51.airWaybills.CreateAnAirWayBill(airWaybillParams);
////                System.out.println(result.getMeta().getCode());
//                if (result.getData() != null) {
//                    AirWaybill airWaybills = (AirWaybill) result.getData();
////                    if ("4".equalsIgnoreCase(airWaybills.getStatusNumber())) {
//                    try {
//                        System.out.println(airWaybills);
//
//                        System.out.println(airWaybills.getAwbNumber());
//                        System.out.println(airWaybills.getAirlineInfo().getName());
//                        System.out.println(Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getFlightNumber());
//                        System.out.println(Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getDepartStation());
//                        System.out.println(Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getDepartTime());
//                        System.out.println(Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getArrivalStation());
//                        System.out.println(Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getArrivalTime());
//                        System.out.println(Arrays.stream(airWaybills.getTrackInfo()).findFirst().get().getStatus());
//                        System.out.println(airWaybills.getWeight());
//                        System.out.println(airWaybills.getPiece());
//                        System.out.println(airWaybills.getAirlineInfo().getTrackUrl());
//
//                        String line = airWaybills.getAwbNumber() + "," +
//                                airWaybills.getAirlineInfo().getName() + "," +
//                                airWaybills.getAirlineInfo().getUrl() + "," +
//                                Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getFlightNumber() + "," +
//                                Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getDepartStation() + "," +
//                                Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getDepartTime() + "," +
//                                Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getArrivalStation() + "," +
//                                Arrays.stream(airWaybills.getFlightInfoNew()).findFirst().get().getArrivalTime() + "," +
//                                Arrays.stream(airWaybills.getTrackInfo()).findFirst().get().getStatus() + "," +
//                                airWaybills.getWeight() + "," +
//                                airWaybills.getPiece() + "," +
//                                airWaybills.getAirlineInfo().getTrackUrl() + "\n";
//                        // 写入几行数据
//                        writer.append(line);
//                        writer.flush();
//                        System.out.println("CSV 文件写入完成: " + csvFile);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        System.out.println("没有查询到记录: " + trackingNuber);
//                    }
////                    }
//                }
//                Thread.sleep(800);
//                tracking++;
//            }
//            writer.close();
//        } catch (Tracking51Exception e) {
//            System.err.println("error：" + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("error：" + e.getMessage());
//        }
    }


}
