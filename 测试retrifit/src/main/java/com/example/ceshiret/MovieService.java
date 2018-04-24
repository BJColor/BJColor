package com.example.ceshiret;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MovieService {
//获取豆瓣Top250 榜单

//说明：定义了一个方法getTop250,使用get请求方式，加上@GET 标签，
// 标签后面是这个接口的 尾址top250,完整的地址应该是 baseUrl+尾址 ，
// 参数 使用@Query标签，如果参数多的话可以用@QueryMap标签，接收一个Map
    @GET("top250")
    Call<MovieSubject> getTop25(@Query("start") int start, @Query("count") int count);


//    说明：使用POST 请求方式时，只需要更改方法定义的标签，
// 用@POST 标签，参数标签用 @Field 或者@Body或者FieldMap，注意：使用POST 方式时注意2点，1，必须加上 @FormUrlEncoded标签，否则会抛异常。2，使用POST方式时，必须要有参数，否则会抛异常, 源码抛异常的地方如下：
//
//    作者：依然范特稀西
//    链接：https://www.jianshu.com/p/5bc866b9cbb9
//    來源：简书
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    @FormUrlEncoded
    @POST
    Call<MovieService> getTop25_Post();
}
