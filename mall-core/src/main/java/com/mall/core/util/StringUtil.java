package com.mall.core.util;

import org.apache.commons.lang3.RandomUtils;

/**
 * 字符串工具类
 *
 * @author suiguozhen on 19/01/31 13:06
 */
public class StringUtil {
    /*** 百家姓*/
    private static final String[] FAMILY_NAME = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
            "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
            "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
            "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
            "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟",
            "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应",
            "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀",
            "羊", "于", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山",
            "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景",
            "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠",
            "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却",
            "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习",
            "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",
            "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",
            "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉",
            "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨",
            "哈", "谯", "篁", "年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",
            "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦", "召", "仪", "风", "介", "巨",
            "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾",
            "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正",
            "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇",
            "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生",
            "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门",
            "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"
    };
    /*** 中间名*/
    private static final String[] MIDDLE_NAME = {
            "希望", "憧憬", "友爱", "锦瑟", "愉快", "勤奋", "刻苦", "认真", "专注", "钻研", "踏实", "勤恳", "潇洒", "坚强", "美丽", "恋夏",
            "漂亮", "自信", "干净", "壮观", "小巧", "玲珑", "健壮", "慈祥", "温柔", "赞许", "欣喜", "安详", "坦然", "腼腆", "害羞", "优美",
            "努力", "爱心", "甜蜜", "积极", "友好", "自信", "勇敢", "坚定", "整齐", "俏丽", "端庄", "文静", "动人", "典雅", "豁达", "美满",
            "和谐", "尊敬", "快乐", "舒心", "整洁", "温暖", "舒服", "称赞", "简洁", "秀丽", "妩媚", "可爱", "匀称", "标致", "喜悦", "感激",
            "欣慰", "甜美", "魅力", "优秀", "幸福", "兴奋", "英俊", "关切", "坚强", "清净", "欢喜", "细挑", "富态", "富相", "丽质", "标致",
            "精悍", "强健", "刚健", "秀丽", "聪慧", "大方", "俏丽", "俊秀", "帅气", "潇洒", "迷人", "魅力", "美丽", "可爱", "陶醉", "吟诵",
            "风铃", "悦耳", "美目", "俊目", "慧眼", "秋波", "明亮", "缥缈", "羽裳", "轩辕", "紫萱", "韶华", "浮光", "烟雨", "蝶舞", "缠绵",
            "绝恋", "碧影", "星愿", "落霞", "忘忧", "幻真", "翩飞", "惊鸿", "星月", "情动", "化羽", "绝影", "醉梦", "波澜", "山岚", "春华",
            "星雨", "浩瀚", "风萧", "浮波", "逐风", "沧澜", "鸿鹄", "如梦", "入画", "青衣", "流影", "舒荷", "霓裳", "清曲", "醉月", "离殇",
            "风和", "瑞雪", "沐宇", "舞纱", "夜渺", "无微", "晨阳", "佳容", "宛碧", "纹香", "梵音", "静晓", "润玉", "嬛绵", "明秀", "邪殇",
            "归云", "春媱", "夏露", "秋颜", "冬耀", "缱绻", "涟漪", "若溪", "微凉", "暖阳", "半夏", "崖悔", "洛尘", "矜柔", "绚烂", "妖娆",
            "矫情", "真淳", "明媚", "迷离", "隐忍", "灼热", "幻灭", "落拓"
    };

    /**
     * 获取全名
     * @return string
     */
    public static String createFullName() {
        return FAMILY_NAME[RandomUtils.nextInt(0, FAMILY_NAME.length)]+MIDDLE_NAME[RandomUtils.nextInt(0, MIDDLE_NAME.length)];
    }
}
