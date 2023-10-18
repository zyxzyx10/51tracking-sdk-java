51tracking-sdk-java
=================

The Java SDK of 51Tracking API

Contact: <service@51tracking.org>

## Official document

[Document](https://www.51tracking.com/v4/api-index/API-)

## Index
1. [Installation](https://github.com/51tracking/51tracking-sdk-java#installation)
2. [Testing](https://github.com/51tracking/51tracking-sdk-java#testing)
3. [Error Handling](https://github.com/51tracking/51tracking-sdk-java#error-handling)
4. SDK
    1. [Couriers](https://github.com/51tracking/51tracking-sdk-java#couriers)
    2. [Trackings](https://github.com/51tracking/51tracking-sdk-java#trackings)
    3. [Air Waybill](https://github.com/51tracking/51tracking-sdk-java#air-waybill)


## Installation

### Maven

```
<dependency>
   <groupId>io.github.51tracking</groupId>
   <artifactId>51tracking-sdk-java</artifactId>
   <version>1.0.0</version>
</dependency>
```

### Gradle

```
implementation "io.github.51tracking:51tracking-sdk-java:1.0.0"
```


## Quick Start

```java
package com.tracking51.maven.example.courier;

import com.tracking51.Tracking51;
import com.tracking51.exception.Tracking51Exception;
import com.tracking51.model.Tracking51Response;
import com.tracking51.model.courier.Courier;

import java.io.IOException;
import java.util.List;

public class ListAllCouriersExample {

   public static void main(String[] args) {
      try {
         String apiKey = "you api key";
         Tracking51 tracking51 = new Tracking51(apiKey);
         Tracking51Response result = tracking51.couriers.getAllCouriers();
         System.out.println(result.getMeta().getCode());
         if(result.getData() != null){
            List<Courier> couriers = (List<Courier>) result.getData();
            for (Courier courier : couriers) {
               String courierName = courier.getCourierName();
               String courierCode = courier.getCourierCode();
               System.out.println(courierName+"---"+courierCode);
            }
         }
      } catch (Tracking51Exception e) {
         System.err.println("error：" + e.getMessage());
      } catch (IOException e) {
         System.err.println("error：" + e.getMessage());
      }
   }

}

```

## Testing
```
mvn test  or  ./gradlew test
```

## Error handling

**Throw** by the new SDK client

```java

try {
    
   String apiKey = "";
   Tracking51 tracking51 = new Tracking51(apiKey);

} catch (Tracking51Exception e) {
  System.err.println("error：" + e.getMessage());
} 

/*
API Key is missing
*/
```

**Throw** by the parameter validation in function

```java

try {
  String apiKey = "you api key";
  Tracking51 tracking51 = new Tracking51(apiKey);
  CreateTrackingParams createTrackingParams = new CreateTrackingParams();
  createTrackingParams.setTrackingNumber("");
  createTrackingParams.setCourierCode("usps");
  Tracking51Response result = tracking51.trackings.CreateTracking(createTrackingParams);
} catch (Tracking51Exception e) {
    System.err.println("error：" + e.getMessage());
} catch (IOException e) {
    System.err.println("error：" + e.getMessage());
}

/*
Tracking number cannot be empty
*/
```
## Examples

### Couriers
##### 返回所有支持的快递公司列表
https://api.51Tracking.com/v4/couriers/all
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   Tracking51Response<List<Courier>> result = tracking51.couriers.getAllCouriers();
   System.out.println(result.getMeta().getCode());
   List<Courier> couriers = result.getData();
   for (Courier courier : couriers) {
       String courierName = courier.getCourierName();
       String courierCode = courier.getCourierCode();
       System.out.println(courierName+"---"+courierCode);
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

### Trackings
##### 单个物流单号实时添加且查询
https://api.51Tracking.com/v4/trackings/create
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   CreateTrackingParams createTrackingParams = new CreateTrackingParams();
   createTrackingParams.setTrackingNumber("92612903029511573030094537");
   createTrackingParams.setCourierCode("usps");
   Tracking51Response<Tracking> result = tracking51.trackings.CreateTracking(createTrackingParams);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null){
       Tracking trackings = result.getData();
       System.out.println(trackings);
       System.out.println(trackings.getTrackingNumber());
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### 获取多个物流单号的查询结果
https://api.51Tracking.com/v4/trackings/get
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   GetTrackingResultsParams trackingParams = new GetTrackingResultsParams();
   trackingParams.setTrackingNumbers("92612903029511573030094537,92612903029511573030094531");
   trackingParams.setCourierCode("usps");
   trackingParams.setCreatedDateMin("2023-08-23T06:00:00+00:00");
   trackingParams.setCreatedDateMax("2023-09-18T06:00:00+00:00");
   Tracking51Response<List<Tracking>> result = tracking51.trackings.GetTrackingResults(trackingParams);
   System.out.println(result.getMeta().getCode());
   List<Tracking> trackings = result.getData();
   for (Tracking tracking : trackings) {
       String trackingNumber = tracking.getTrackingNumber();
       String courierCode = tracking.getCourierCode();

       System.out.println("Tracking Number: " + trackingNumber);
       System.out.println("Courier Code: " + courierCode);
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### 添加多个物流单号（一次调用最多创建 40 个物流单号）
https://api.51Tracking.com/v4/trackings/batch
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   List<CreateTrackingParams> paramsList = new ArrayList<>();

   CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
   createTrackingParams1.setTrackingNumber("92632903279511573030094832");
   createTrackingParams1.setCourierCode("usps");

   CreateTrackingParams createTrackingParams2 = new CreateTrackingParams();
   createTrackingParams2.setTrackingNumber("92642903289511563039994932");
   createTrackingParams2.setCourierCode("usps");

   paramsList.add(createTrackingParams1);
   paramsList.add(createTrackingParams2);

   Tracking51Response<BatchResults> result = tracking51.trackings.BatchCreateTrackings(paramsList);
   System.out.println(result.getMeta().getCode());
   BatchResults batchResults = result.getData();
   if(result.getData() != null){
       System.out.println(batchResults);
       for (BatchItem batchItem : batchResults.getSuccess()) {
           String trackingNumber = batchItem.getTrackingNumber();
           String courierCode = batchItem.getCourierCode();
           System.out.println("Tracking Number: " + trackingNumber);
           System.out.println("Courier Code: " + courierCode);
       }
       for (BatchItem batchItem : batchResults.getError()) {
           String trackingNumber = batchItem.getTrackingNumber();
           String courierCode = batchItem.getCourierCode();
           System.out.println("Tracking Number: " + trackingNumber);
           System.out.println("Courier Code: " + courierCode);
       }
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### 根据ID更新物流信息
https://api.51Tracking.com/v4/trackings/update/{id}
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   String idString = "9a035f5cdd0437c55d48e223c705a66c";
   UpdateTrackingParams updateTrackingParams = new UpdateTrackingParams();
   updateTrackingParams.setCustomerName("New name");
   updateTrackingParams.setNote("New tests order note");
   Tracking51Response<UpdateTracking> result = tracking51.trackings.UpdateTrackingByID(idString, updateTrackingParams);
   System.out.println(result.getMeta().getCode());
   System.out.println(result.getData());
   if(result.getData() != null){
       UpdateTracking  updateTracking= result.getData();
       System.out.println(updateTracking);
       System.out.println(updateTracking.getTrackingNumber());
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### 通过ID删除单号
https://api.51Tracking.com/v4/trackings/delete/{id}
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   String idString = "9a28d8ba030596de70c1b0134cdc8b0d";
   Tracking51Response<Tracking> result = tracking51.trackings.DeleteTrackingByID(idString);
   System.out.println(result);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null) {
       Tracking trackings = result.getData();
       System.out.println(trackings);
       System.out.println(trackings.getTrackingNumber());
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### 通过ID重新查询过期的单号
https://api.51Tracking.com/v4/trackings/retrack/{id}
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   String idString = "9a035f5cdd0437c55d48e223c705a66c";
   Tracking51Response<Tracking> result = tracking51.trackings.RetrackTrackingByID(idString);
   System.out.println(result);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null){
       Tracking  tracking= result.getData();
       System.out.println(tracking);
       System.out.println(tracking.getTrackingNumber());
   }
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}
```
### Air Waybill
##### 查询航空运单的结果
https://api.51Tracking.com/v4/awb
```java
try {
   String apiKey = "you api key";
   Tracking51 tracking51 = new Tracking51(apiKey);
   AirWaybillParams airWaybillParams = new AirWaybillParams();
   airWaybillParams.setAwbNumber("235-69030430");
   Tracking51Response<AirWaybill> result = tracking51.airWaybills.CreateAnAirWayBill(airWaybillParams);
   System.out.println(result.getMeta().getCode());
   AirWaybill airWaybills = result.getData();
   System.out.println(airWaybills);
   System.out.println(airWaybills.getAwbNumber());
   System.out.println(airWaybills.getAirlineInfo().getName());
} catch (Tracking51Exception e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

## 响应状态码

51Tracking 使用传统的HTTP状态码来表明 API 请求的状态。通常，2xx形式的状态码表示请求成功，4XX形式的状态码表请求发生错误（比如：必要参数缺失），5xx格式的状态码表示 51tracking 的服务器可能发生了问题。

Http CODE|META CODE|TYPE | MESSAGE
----|-----|--------------|-------------------------------
200    |200     | <code>成功</code>        |    请求响应成功。
400    |400     | <code>错误请求</code>     |    请求类型错误。请查看 API 文档以了解此 API 的请求类型。
400    |4101    | <code>错误请求</code>     |    物流单号已存在。
400    |4102    | <code>错误请求</code>     |    物流单号不存在。请先使用「Create接口」将单号添加至系统。
400    |4103    | <code>错误请求</code>     |    您已超出 API 调用的创建数量。每次创建的最大数量为 40 个快递单号。
400    |4110    | <code>错误请求</code>     |    物流单号(tracking_number) 不符合规则。
400    |4111    | <code>错误请求</code>     |    物流单号(tracking_number)为必填字段。
400    |4112    | <code>错误请求</code>     |    查询ID无效。
400    |4113    | <code>错误请求</code>     |    不允许重新查询。您只能重新查询过期的物流单号。
400    |4120    | <code>错误请求</code>     |    物流商简码(courier_code)的值无效。
400    |4121    | <code>错误请求</code>     |    无法识别物流商。
400    |4122    | <code>错误请求</code>     |    特殊物流商字段缺失或填写不符合规范。
400    |4130    | <code>错误请求</code>     |    请求参数的格式无效。
400    |4160    | <code>错误请求</code>     |    空运单号(awb_number)是必需的或有效的格式。
400    |4161    | <code>错误请求</code>     |    此空运航空不支持查询。
400    |4165    | <code>错误请求</code>     |    查询失败：未创建空运单号。
400    |4166    | <code>错误请求</code>     |    删除未创建的空运单号失败。
400    |4167    | <code>错误请求</code>     |    空运单号已存在，无需再次创建。
400    |4190    | <code>错误请求</code>     |    当前查询额度不足。
401    |401     | <code>未经授权</code>   |    身份验证失败或没有权限。请检查并确保您的 API 密钥正确无误。
403    |403     | <code>禁止</code>      |    禁止访问。请求被拒绝或不允许访问。
404    |404     | <code>未找到</code>       |    页面不存在。请检查并确保您的链接正确无误。
429    |429     | <code>太多请求</code>|    超出 API 请求限制，请稍后重试。请查看 API 文档以了解此 API 的限制。
500    |511     | <code>服务器错误</code>    |    服务器错误。请联系我们： service@51Tracking.org。
500    |512     | <code>服务器错误</code>    |    服务器错误。请联系我们：service@51Tracking.org。
500    |513     | <code>服务器错误</code>    |    服务器错误。请联系我们： service@51Tracking.org。