package com.tracking51.maven.example.airWaybill;

import lombok.SneakyThrows;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class AwbExample {
    int waitingTime = 5000;

    @SneakyThrows
    public static void main(String[] args) {
        new AwbExample().check160();
//        new AwbExample().check988();
//        new AwbExample().check369();


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
//                Thread.sleep(waitingTime);
//                tracking++;
//            }
//            writer.close();
//        } catch (Tracking51Exception e) {
//            System.err.println("error：" + e.getMessage());
//        } catch (IOException e) {
//            System.err.println("error：" + e.getMessage());
//        }
    }


    // 国泰航空
    private void check160() throws URISyntaxException, IOException, InterruptedException {
//        int tracking = 93192961L;//yvr -> hk
//        int tracking = 86826760L;//LAX -> hk
//        int tracking = 93192934L;//加拿大，3月
//        int tracking = 92412000;//加拿大，8月
//        int tracking = 93197720;//10月，温哥华到香港
        int tracking = 93190799;

        for (int i = 0; i < 30; i++) {// 800 个一轮
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

            // 要打开的网址
//            URI url = new URI("https://www.51tracking.com/aircargo/cn/" + trackings); TODO remove this
            URI url = new URI("https://www.track123.com/cn/track?trackNos=" + trackings);
            // 检查系统是否支持 Desktop 类
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(url);
                System.out.println("已在默认浏览器中打开 URL。");
            } else {
                System.out.println("当前系统不支持 Desktop API。");
            }
            Thread.sleep(waitingTime);
//            System.out.println("https://www.track123.com/cn/track?trackNos=" + trackings);

            tracking++;
        }


        System.out.println("下一个号码。" + tracking);
    }

    // 韩亚航空 lax -> hk
    private void check988() throws IOException, InterruptedException, URISyntaxException {
        long tracking = 89197082L;//1月
        for (int i = 0; i < 20; i++) {// 800 个一轮
            String trackings = "988-" + tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking++ + ",988-";
            trackings += tracking + "";

            // 要打开的网址
//            URI url = new URI("https://www.51tracking.com/aircargo/cn/" + trackings); TODO remove this
            URI url = new URI("https://www.track123.com/cn/track?trackNos=" + trackings);
            // 检查系统是否支持 Desktop 类
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(url);
                System.out.println("已在默认浏览器中打开 URL。");
            } else {
                System.out.println("当前系统不支持 Desktop API。");
            }
            Thread.sleep(waitingTime);

//            System.out.println("https://www.track123.com/cn/track?trackNos=" + trackings);

            tracking++;
        }


    }


    // 美国阿特拉斯航空公司 yvr -> hk
    private void check369() throws URISyntaxException, IOException, InterruptedException {
//        long tracking = 92655371L;
//        long tracking = 92650272L;//12月
//        long tracking = 92653632L;//2025 7月
//        long tracking = 94542103L;//2025 7月

//        long tracking = 94544400L;//2025 7月
        long tracking = 92654600L;//2025 7月

        for (int i = 0; i < 20; i++) {// 800 个一轮
            String trackings = "369-" + tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking++ + ",369-";
            trackings += tracking + "";

            // 要打开的网址
//            URI url = new URI("https://www.51tracking.com/aircargo/cn/" + trackings); TODO remove this
            URI url = new URI("https://www.track123.com/cn/track?trackNos=" + trackings);
            // 检查系统是否支持 Desktop 类
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(url);
                System.out.println("已在默认浏览器中打开 URL。");
            } else {
                System.out.println("当前系统不支持 Desktop API。");
            }
            Thread.sleep(waitingTime);
//            System.out.println("https://www.track123.com/cn/track?trackNos=" + trackings);

            tracking++;
        }


    }
}
