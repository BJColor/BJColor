package com.example.xysm.bjcolor.banben;

/**
 * 公共常量Util
 * if (ConstantUtil.VERSION_INFO == VersionInfo.NATION) {
 *
 *         } else {
 *
 *         }
 *
 *
 *
 *
 */
public class ConstantUtil {


//    public static final VersionInfo VERSION_INFO = VersionConfig.versionInfoConfig;

    public static boolean NOT_4_4 = true; //配置是否为有串口版


    //请求地址
    public static final String USER_LOGIN_SERVICE = "/security/idssso/userlogin";

    //地址添加URL
    public static final String ADDR_ADD_URL = "mobile/index.php?act=member_address&op=address_add";

    //地址查询
    public static final String ADDR_SEARCH_URL = "mobile/index.php?act=member_address&op=address_list";
    //地址编辑
    public static final String ADDR_EDIT_URL = "mobile/index.php?act=member_address&op=address_edit";
    //删除地址
    public static final String ADDR_DEL_URL = "mobile/index.php?act=member_address&op=address_del";

    //获取首页资讯图片
    public static final String CONSULT_HOME_IMAGE_URL = "tft/information/authCom/findIndex";

    //红酒资讯首页
    public static final String CONSULT_HOME_URL = "tft/information/authCom/findPlate";
    //红酒资讯列表
    public static final String CONSULT_LIST_URL = "tft/information/findInfo";
    //红酒资讯详情
    public static final String CONSULT_DETAIL_URL = "tft/information/getInfo";

    //在线商城
    public static final String ADDR_ONLINE_SHOP = "mobile/index.php";
    public static final String ADDR_SHOP_LIST = "tft/goods/authCom/findGoodsPage";
    //在线商城分类
    public static final String SHOP_LIST_KIND = "tft/goods/authCom/findClassArea";
    //商用版商城首页
    public static final String COM_SHOP_HOME = "tft/advert/authCom/shopIndex";
    //家用版商城首页
    public static final String FAM_SHOP_HOME = "tft/advert/shopIndex";

    //商品详情页
    public static final String GOODS_DETAIL = "mobile/index.php?act=goods&op=goods_detail";

    //商品详情页的商品介绍
    public static final String GOODS_DETAIL_INFO = "mobile/index.php?act=goods&op=goods_body";

    //商用版订单管理
    public static final String ORDER_COM_MANAGEMENT = "tft/orders/authCom/getOrderList";
    //家用版订单管理
    public static final String ORDER_FAM_MANAGEMENT = "tft/orders/authFam/getOrderList";

    //添加商品
    public static final String ADD_GOODS = "mobile/index.php?act=member_cart&op=cart_add";

    //立即购买
    public static final String NOW_SALE = "mobile/index.php?act=member_buy&op=buy_step1";

    //立即购买第二步
    public static final String NOW_SALE2 = "mobile/index.php?act=member_buy&op=buy_step2";

    //获取地址关联信息
    public static final String ADDR_API = "mobile/index.php?act=member_buy&op=change_address";

    //家用版主推商品
    public static final String HOME_MAIN_STAY = "tft/goods/findPlateGoods";
    //商用版主推商品
    public static final String BUSS_MAIN_STAY = "tft/goods/authCom/findGoodsByCustomPlateId";

    //食谱列表
    public static final String RECIPE_LIST = "tft/greens/authCom/findList";
    //推荐排行榜
    public static final String RECIPE_RANK_LIST = "tft/recommend/authCom/findList";
    //食谱详情
    public static final String RECIPE_DETAIL = "tft/greens/authCom/findDetail";

    //上传状态
    public static final String UPLOAD_STATUS = "tft/devices/authCom/uploadStatus";
    //上传地理位置
    public static final String UPLOAD_LOCATION = "tft/devices/authCom/uploadLocation";

    //亮屏欢迎页
    public static final String WELCOM_PAGE = "tft/advert/authCom/findWelcomImage";

    //检查酒品在本酒柜的库存状态
    public static final String CHECK_WINE_STATUS_NEW = "tft/wineManage/checkWineStatusNew2";

    //相似酒品
    public static final String SIMILAR_WINE = "tft/goods/authCom/v2/findSimilarGoodsCustom";
    //获取分类列表
    public static final String MANAGE_KIND_LIST = "tft/wineManage/getWineClass";
    //添加分类
    public static final String MANAGE_KIND_ADD = "tft/wineManage/addClass";
    //删除分类
    public static final String MANAGE_KIND_DEL = "tft/wineManage/delClass";

    //加入酒品
    public static final String ADD_WINE = "tft/wineManage/addWine";
    //移除酒品
    public static final String DEL_WINE = "tft/wineManage/removeWine";
    //获取酒品列表
    public static final String GAIN_WIME_LIST = "tft/wineManage/getWineList";
    //拖拽更新酒品列表
    public static final String UPDATA_WIME_LIST = "tft/wineManage/updateWineInfo";

    //酒品列表
    public static final String WINE_LIST = "tft/wineManage/authCom/findList";

    //与餐同结
    public static final String BUY_WITH_MEAL = "tft/offlineOrder/authCom/mealOrder";

    //退回酒柜
    public static final String BACK_WINE = "tft/offlineOrder/authCom/returnOrder";

    //微信线下支付
    public static final String WEIXIN_PAY = "tft/offlineOrder/authCom/weixinPay";

    //线下订单列表
    public static final String UNDERLINE_ORDER = "tft/offlineOrder/authCom/findPage";

    //商城ShopNC订单列表
    public static final String SHOPNC_ORDER_LIST = "tft/offlineOrder/authCom/findShopncPage";

    //线下订单的数量
    public static final String UNDERLINE_NUMBER = "tft/offlineOrder/authCom/getCount";

    //商城ShopNC订单的数量
    public static final String SHOPNC_ORDER_COUNT = "tft/offlineOrder/authCom/getShopncCount";

    //货单
    public static final String MANIFEST_ORDER = "tft/sales/order/authCom/findList";

    //确认货单
    public static final String CONFIRM_MANIFEST = "tft/sales/order/authCom/confirm";

    //根据定制号获取E侍酒版apk
    public static final String CUSTOM_VERSION_INFO = "tft/appVersion/getCustomVersionInfo";

    //初始化当前临时激活的设备---E侍酒版本安装完毕后转为E侍酒版
    public static final String INIT_DEVICES = "tft/devices/initMac";

    //根据MAC获取设备信息
    public static final String DEVICE_USER_INFO = "tft/devices/getDeviceUserInfo";
    //根据MAC获取类型+产地信息
    public static final String WINE_TYPE_AREA = "tft/goods/authCom/findClassAreaStock";
    //根据类型+产地信息搜索酒品
    public static final String SEARCH_TYPE_AREA = "tft/goods/authCom/findStockDetail";

    //获取支付酒品列表
    public static final String GET_PAY_ORDER = "mobile/index.php?act=wine_order&op=wine_orderList";

    //获取支付酒品列表
    public static final String GET_WINE = "mobile/index.php?act=wine_order&op=wine_order_change";
    //获取服务员二维码
    public static final String GET_WATER_QR = "mobile/index.php?act=wine_order&op=wine_qr";
    //三代主板获取OS
    public static final String OTA_OS = "tft/otaOs/ota";
    //三代主板获取OS强制升级
    public static final String OTA_OS_FORCE = "tft/otaOs/otaForce";
    //三代主板获取APK
    public static final String OTA_APK = "tft/ota/app";


}
