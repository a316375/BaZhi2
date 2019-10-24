package xyxgame.bazhi2.jiemen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JieMengWords {

    public static List<String> Say(){
        List<String> list= Arrays.asList(
                //原版周公解梦之 一、天地 日月 星辰\n" +
                "天门开贵人荐引 天光灼身疾病除 天晴雨散百忧去 天明妇有生贵子\n" +
                "天门未至有兵荒 仰面向天大富贵 乘龙上天主大贵 上天求妻儿女贵\n" +
                "上天取物位王侯 飞上天富贵大吉 癸天上屋得高官 天裂有分主国忧\n" +
                "天皇明主公卿至 天欲晓益寿命吉 渡天河主有所吉 天地合所求皆得\n" +
                "天公使有大吉祥 日月初出家道昌 日月照身得重位 日月落忧没父母\n" +
                "日月昏暗孕妇吉 日月欲出有官职 日月合会妻有子 日月衔山奴欺主\n" +
                "负抱日月贵王侯 吞日月当生贵子 礼拜日月大吉昌 日光入屋官位至\n" +
                "日初出无云大吉 日出有光有好事 云开日出凶事散 日入怀贵子月女\n" +
                "拜星月烧香大吉 云忽遮日有阴私 星入怀主生贵子 星落有病及官事\n" +
                "星列行主添奴婢 持执星宿大富贵 流星不落主移居 巡天摩星位公卿\n" +
                "云起四方交易吉 五色云主大吉昌 云赤白吉青黑凶 见浮云作事不成\n" +
                "云雾遮事大吉利 黑云压地时气病 霜雪降主事不成 雪下及时大吉利\n" +
                "雪落身上万事成 雪不沾身主孝服 雪落家庭主丧事 阴雨晦时主囚事\n" +
                "行路逢雨有酒食 雷霆作声官位至 雷声恐怕私居吉 雷从地震主志遂\n" +
                "身被霹雳主富贵 电光照身有吉庆 赤虹见吉黑虹凶 霞满天百事欢悦\n" +
                "狂风大雨人死亡 风吹人衣主疾病 忽大风国有号令 风如吼主远信至",
                //原版周公解梦之 二、地理 山石 树木\n" +
                "地动主迁官位吉 地裂主疾病大凶 修平田地大吉昌 地高下不平主病\n" +
                "卧于石上主大吉 地中黑气上主凶 运石入家主富贵 石上得利禄大吉\n" +
                "盘石安稳无忧疑 登岩抱石官职迁 手弄小石生贵子 身人土中百事吉\n" +
                "自身取土被耻辱 升山落地主失位 居住高山有喜事 山行得财有福禄\n" +
                "抱物上山孕贵子 山中农稼衣食丰 枯木再发子孙兴 堂上地陷主安忧\n" +
                "园林茂盛大吉利 树木枯死宅不安 林中坐卧病欲痊 树木凋零主人凶\n" +
                "林中树生添贵子 种树木者大吉昌 登大树名利显扬 上树忽折有死伤\n" +
                "与人分花主分散 枯木开花兴子孙 大树落叶屋中吉 立树下贵人庇阴\n" +
                "树生堂上父母忧 大木忽折主凶恶 担水来家得财喜 砍伐大树多得财\n" +
                "草木茂盛家道兴 门中生果树有子 松生屋上位三公 家中生松事转丰\n" +
                "家中生柏大吉利 庭前竹木喜重重 枫生屋上百事遂 兰生庭前主添孙\n" +
                "果林中行主得财 入果园中大发财 桑生井上主有忧 果树多熟子孙安\n" +
                "折笋到家女有子 见笋者主添子孙 扫地除粪家欲破 粪土堆者钱财聚",
                //原版周公解梦之 三、身体 面目 齿发\n" +
                "自身白衣人所谋 梳头洗面百忧去 身拜尊长大吉昌 身上汗出主凶恶\n" +
                "身病虫出得重职 身上虫行病患安 绳索系身长命吉 枷索临身病欲来\n" +
                "身或肥瘦皆为凶 面对官者主大吉 露体无衣吉大利 妇人披头有私情\n" +
                "头白主长命大吉 头生两角有争竞 头秃发落皆凶事 面生疮黑主子凶\n" +
                "头须自落忧子孙 头须再生主长命 沐浴迁官疾病除 洗手洗足旧患除\n" +
                "照镜明吉暗者凶 破镜照人主分散 手足浓血出大吉 屎尿污人大吉亨\n" +
                "露头披发阴人谋 披头盖面官讼至 剪剃头发家内凶 眉与发齐禄位至\n" +
                "齿自落者父母凶 齿落更生子孙兴",
                //原版周公解梦之 四、冠带 衣服 鞋袜\n" +
                "戴冠登车官欲迁 自戴帽头巾帽吉 簪冠登台职位迁 贵人与之衣冠吉\n" +
                "新换衣冠禄位至 烧毁官帽欲更官 失去官帽主退职 拾得冠带禄位至\n" +
                "与人公服主得职 人与公服加官职 女着冠带主生子 洗笏染服新官来\n" +
                "执笏见贵人大吉 笏破忧凶主不祥 与人笏授主官迁 腰带者主官至吉\n" +
                "文书用印有名声 带印主妻生贵子 着新袍主添妻妾 着锦绣衣子孙荣\n" +
                "洗染衣服皆大吉 披蓑衣主大恩至 被油污衣大恩泽 衣服忽破妻外心\n" +
                "新衣攒来百事凶 与人衣服主患至 裁衣着孝衣皆吉 衣带自解百事吉\n" +
                "着黄衣皂衣皆吉 着白衣主有人请 着青衣神有助力 着蓝绣衣妻大利\n" +
                "从人着紫主情弊 众人着青家人散 众人着白主官事 众人着红大吉利\n" +
                "妻着夫衣生贵子 女人着衫平无事 与人共衣妾私情 失却衣服妻难产\n" +
                "好被自盖得富贵 人着己履妻有私 得靴鞋主奴婢吉 的履主奴婢逃走\n" +
                "脱靴束带主有凶 鞋破子孙妻妾病 着麻鞋百事和合 新授官爵主贵子\n" +
                "乞得鞋履人助力 木履脱时已出危",
                //原版周公解梦之 五、刀剑 旌节 钟鼓\n" +
                "君主队杖有异吉 旌旗受宠大吉利 抱旌节主贵人扶 旌旗引入山主凶\n" +
                "造旌盖主大吉利 羽益盖身主富贵 旌旗迎接大富贵 旗幡竞出主疾病\n" +
                "手持旌节有恩偿 自盖覆身大吉利 见做新旗大吉利 与人分金主分散\n" +
                "拔刀出行大吉利 得人刀主行人至 人与三刀作刺史 与人相砍大吉庆\n" +
                "被刀出血得酒食 持刀刺人主失利 刀斧自伤大吉利 得人刀斧禄位至\n" +
                "刀落水中妻妾亡 失落刀剑主破财 带刀剑行有财利 磨刀剑锋快大古\n" +
                "与人刀剑皆主凶 剑在床头大吉利 女人带刀大吉庆 女人拔刀主有子\n" +
                "剪刀主分财之事 剪刀剪物主得财 剪刀折股妻妾凶 甲胄披身护吉利\n" +
                "枪槊主官位吉利 见军兵败主有凶 钟磐有声远人来 钟鼓大鸣福禄至\n" +
                "打鼓有声远有来 见鼓住声欢乐吉 见鼓不鸣凶必至 看放烟火有忧散",
                //原版周公解梦之 六、帝王 文武 呼召\n" +
                "帝王宣召有惊喜 后妃呼召饮有疾 太子召大喜吉利 天子赐坐有财吉\n" +
                "王侯并坐大吉利 来见贵人不得凶 与圣贤说诣大吉 使命入门大吉利\n" +
                "白衣召作使死亡 拜尊长者有吉庆 先祖考言求食吉 人云大好者即凶\n" +
                "人云死者得长命 人在外呼之主凶 我欲共汝去大凶 人云不用汝大吉\n" +
                "与恶人言有口舌 被杀害吉伏藏凶 身生羽翼飞大吉 身逃走得脱病去\n" +
                "与人交易主有疾 贫穷共居主大吉 合伴同行凶事至 一切贵人皆吉利",
                //原版周公解梦之 七、宫室 屋宇 仓库\n" +
                "入帝王官行大吉 拜朝廷者主富贵 入王侯府主大吉 行道宫见仙主吉\n" +
                "坐官府中主大吉 神庙广大事事吉 上楼阁坛俱大吉 上高堂大富贵至\n" +
                "高楼饮酒富贵至 家起高楼安稳事 上城为人所拽吉 上城被执官职显\n" +
                "城郭广大财喜多 城中行凶出门吉 连城青色有喜吉 登赤城郭主大吉\n" +
                "盖城上屋大吉利 上屋主富出园吉 上屋破坏家道凶 堂上有棺身安乐\n" +
                "正堂倒陷家主凶 覆盖屋宇长命吉 屋宅更新主大吉 风吹屋动主迁移\n" +
                "迁入他人新宅吉 居田宅主妻喜事 搬移破屋主美妻 人或典房主官让\n" +
                "家道贫穷大吉利 洒扫宅舍远人来 典卖田舍主失位 屋宅无人主死亡\n" +
                "屋下穿身有暗昧 逾墙度宅险事去 与人争屋主大凶 与妇人争屋主吉\n" +
                "房梁忽折主大凶 院宅坑下主死亡 妻男墙下官位至 墙上掘土主更改\n" +
                "军人入宅主大吉 死央瓦落妇争斗 屋中生马男信至 尾中生草家欲空\n" +
                "屋上生松柏益寿 修理田舍有大喜 入寺院中生贵子 寺舍看经病人痊\n" +
                "迁移尼寺主病至 超盖仓库福禄至 仓库崩坏百事凶 入仓库中大吉昌",
                //原版周公解梦之 八、门户 井灶 橱厕\n" +
                "门户高大主富贵 新开门户大富贵 门户忽开主大吉 门户大开大吉利\n" +
                "门更新主生贵子 门自开妻有私情 门户裂开主大吉 门户破碎有凶事\n" +
                "城门大开主口舌 宫城塞者口舌至 门户闭塞事不能 门户败坏主大凶\n" +
                "门扇自折奴仆走 门户内无人大凶 修移门户大吉利 石为门户主寿命\n" +
                "门前生洲作刺史 门前坑沟事不成 天火烧门主凶事 屋开小门主私情\n" +
                "穿并见水远信至 井自损坏家大败 井中沸溢主得财 井枯涸者家财散\n" +
                "井中照身禄位至 身坠井中疾病凶 屋在井中主见病 取井水清吉浑凶\n" +
                "井中伏泥出主财 井中欲于家欲败 井中有鱼身主贵 窥井有声口舌生\n" +
                "伏藏井中刑狱事 醉落井中官事至 家住井中长子匈 人云出井喜事至\n" +
                "掏井造井主大贵 器皿落井有急事 灶下水流得横财 灶下燃火有声名\n" +
                "灶釜破败有死亡 灶下炊者家破败 灶下器鸣主口舌 屋有二灶事不成\n" +
                "修造炊灶大吉利 在官厨中得财禄 自炊日中妻妾之 掏厕者主得横财\n" +
                "上厕在尿屎中吉 厕中屎溢大吉利 粪中坐者主大凶 粪土堆积主得财",
                //原版周公解梦之 九、金银 珠玉 绢帛\n" +
                "金银宝者主富贵 金银珠玉大吉利 金银杯皿有贵孕 金银作铛器大吉\n" +
                "玉积如山大富贵 得金玉环生贵子 铜裆主有口舌至 珠玉满怀主大凶\n" +
                "得玉碗器物皆吉 见铁器物主得财 铅与锡者主得财 得铜物主大富贵\n" +
                "镶铅器物疾病去 还人钱物疾病去 拾得钱物皆大吉 钱春夏吉秋冬凶\n" +
                "家中分财主离散 赠彩帛者主有权 贵人赐绫锦官至 人赐绢帛大吉昌\n" +
                "与人丝帛大凶恶 得他人麻布衣凶 得布帛远亲来至 与人衣服官事至\n" +
                "寻丝绢主进入口 纺绩者主寿命长 经络者主被人辱 箱器生口舌之事",
                //原版周公解梦之 十、镜环 钗钏 梳蓖\n" +
                "镜明者吉暗者凶 拾得镜者招好妻 将镜自照远信至 镜照他人妻妾凶\n" +
                "得他人镜有贵子 他人弄己镜妻凶 镜破主夫妇离别 金钗动有远行事\n" +
                "金钿成双增爱妾 钗钏相敲妻别凶 金钗耀主生贵子 花钗妻妾有奸妄\n" +
                "银钗夫妻主相殴 花压妻妾生外心 人与梳蓖得美妾 牙木梳旧事尽去\n" +
                "见蓖子贵子提携 得蓖子者美女至 刷牙者病患不生 行胭脂粉主生女\n" +
                "见脂粉主大财利 得粉扑妻生桥女 手帕者主口舌事 得外线者百事就",
                //原版周公解梦之 十一、床帐 毡祷 匙筋\n" +
                "床帐改主官迁移 舒展床帐大富贵 新安床帐远人来 床帐出门者妻亡\n" +
                "床帐改换移居吉 床上有蚁主不祥 床帐破损妻欲亡 开帐幔主有酒食\n" +
                "帐幔坏者妻子病 床脚新换奴仆凶 上床卧者大凶恶 血在床妻妾有奸\n" +
                "洗床收则主大吉 荐席入吉出则凶 破席者主失官位 换席入吉出则凶\n" +
                "席箪者主有力助 毡褥铺陈万事稳 毁帘幔者妻有奸 新帘者主得好妻\n" +
                "铺席合坐得官位 好被自盖主大吉 见好枕有贵人扶 见手帕主有口舌\n" +
                "手巾缚布病患至 毛扇忽持官事吉 鼎鼐者主得大财 釜溢者主得大财\n" +
                "玉石器主有人助 铜铛者生口舌至 锅铁破主丧事来 裆盏被主有恶事\n" +
                "瓷碗者主酒食至 瓷碟者主口舌至 匙主益妻妾子孙 筋主益田宅奴仆\n" +
                "盆主益仓库大吉 掇盆脱底主财散 火盆瓮器大富贵 洗面盆着美妾至\n" +
                "大小盆者主团圆 得盒子者所求得 桶盛水者主大吉 桶无水者主大凶\n" +
                "人送大桶主得利 桌架于宅事不成 锯主有断决之事 碾衣石移居大吉\n" +
                "锤钻者主侵害事 锤欲举动有人扶 凿主被人驱使吉 熨斗盛火好事成\n" +
                "熏笼者益增产业 人与秤者主权位 绳索主长命大吉 绳索断者主凶恶\n" +
                "人与凿者得抬金 人送帚者主得位",
                //原版周公解梦之 十二、船车 游行 物价\n" +
                "船飞行主大富贵 船浅在岸是非厄 乘船渡江河得官 船中有水主得财\n" +
                "乘船看日月得职 乘船过日月主宫 乘船饮酒远客至 与人同船主移居\n" +
                "乘船风帆大吉利 乘船见航主安稳 乘船桥下过大吉 病人乘船必主死\n" +
                "助人行船官位至 身卧船中主有凶 执火入船主大吉 家中乘船主没财\n" +
                "乘船看花酒食至 船车破碎主不详 车轮破夫妻相别 车轮折倒主破败\n" +
                "车载不起厄事去 骂车游行禄位至 车行主百事顺利 车不行所求不遂\n" +
                "车入门主有凶事 病人上车主大凶 丧车过者主灾散 行车白马主大吉\n" +
                "四马驾车吉反凶 以羊驾车事不常 备马者生远行事 远行出入命通达",
                //原版周公解梦之 十三、道路 桥梁 集市\n" +
                "见四通路名利遂 道中得财主通达 道泥荆棘事大成 大道崩馅主失财\n" +
                "修桥梁者万事和 见流桥主有官事 桥上坐立禄位至 见桥坏主有官事\n" +
                "携手上桥妻有孕 桥上呼唤讼得理 新造桥者大和合 桥断者主有口舌\n" +
                "桥柱折者子孙凶 桥路上住车皆凶 夫妇入市主置产 见市中无人主凶",
                //原版周公解梦之 十四、夫妻 产孕 交欢\n" +
                "夫妇宴会主相别 夫妇相骂主疾病 夫妻分钗主离别 夫妻相打欲和会\n" +
                "同妇人行主失财 抱妇人主有喜事 与妇人交有邪崇 与妇人共坐大吉\n" +
                "交接男子主失财 妻着锦衣生贵子 妻有争主外私情 见妇人阴主口舌\n" +
                "妇人赤身主大吉 男子裸体命通达 兄弟分别口舌临 抱小儿女主口舌\n" +
                "小儿死者主口舌 新生男女主大吉 见嫁聚及孝主凶 男子化为尼姑凶",
                //原版周公解梦之 十五、饮食 酒肉 瓜果\n" +
                "人请饮酒主长命 与人饮酒有口舌 与人吃会富贵至 宴会客人家欲破\n" +
                "饮酒者主哭泣事 饮酒至醉主疾病 贵人赐宴主疾病 与贵人对饮大吉\n" +
                "人请吃酥酪主喜 与人吃乳尊亲至 与人吃蜜大吉利 呕吐者病人出痊\n" +
                "食水者主很大利 死人食者主疾病 食羊肉于堂上吉 食大肉主有争讼\n" +
                "食猪肉主疾病至 刀割猪肉主生病 食生肉凶熟肉吉 食自死肉主别离\n" +
                "食鹅肉主妾疾病 食鸡鸭等肉皆吉 食馒头主口舌散 见馒头未食主气\n" +
                "食烂瓜主生疾病 食饼食饭心不遂 食瓜子主生贵子 食柿食柑主疾病\n" +
                "食葡萄离而复合 食枣者主生贵子 食桑甚主生贵子 食栗者主有分别\n" +
                "食梨者主失财帛 食一初果者凶至 食茄者主妻有子 食葱韭主有争斗\n" +
                "食薤者有重丧至 食蒜者有灾害事 食菜黄主凶事至 食油盐酱酸豉吉",
                //原版周公解梦之 十六、冢墓 馆郭 迎送\n" +
                "冢墓高者大吉利 新冢棺郭主忧除 冢墓上有云气吉 冢基门开百事吉\n" +
                "冢墓上明吉暗凶 冢墓生树吉折凶 冢墓上开花大古 墓中棺自出大吉\n" +
                "将棺入宅禄位至 死人出棺外客至 开棺与死人言凶 棺敛死人主得财\n" +
                "升棺水上大得财 空野无人主远行",
                //原版周公解梦之 十七、文书 笔墨 兵器\n" +
                "各色经书大富贵 五色纸者大益财 吞五色纸诗书进 几上有书禄位至\n" +
                "读书文写字大吉 有人教书大富贵 见读书者主聪明 观人读书生贵子\n" +
                "得历日者中黄甲 封书信者主通达 手弄笔砚主远信 人与墨者文章进\n" +
                "人将已笔文章退 他人起笔主财进 君王队伍有异名 得大赦者宅舍凶\n" +
                "就人卜易主疾病 受人纸钱主大吉 公座移动主迁官 受职上官财物来\n" +
                "佩印公爵主大吉 佩印执笏主移居 佩印信者名准出 印绶改迁生贵子\n" +
                "棋子主添丁进口 打球者主得虚名 兵马入城福禄至 率众破贼所求得\n" +
                "见军兵败主凶事 已射人必主远行 人射已有行人至 持弓夭者主大吉\n" +
                "挽弓弦断主凶恶 人送弓弩得人力 弩弦难上兄弟散 弓弩相斗生争论\n" +
                "戈铖有光禄们至 披甲杖剑得高官",
                //原版周公解梦之 十八、哀乐 病死 歌唱\n" +
                "与人哭泣有庆贺 放声大哭欢乐生 身着孝服官禄至 远人来悲泣主凶\n" +
                "床上哭泣主大凶 见歌舞者口舌至 家中欢喜百事吉 怀中琵琶行人力\n" +
                "他人与笛有名声 与人扣板有口舌 堂上歌乐主丧事 吹笙者主有更欢\n" +
                "吹笛打鼓有吉庆 他人作乐讼有理 露齿哭者有争讼 病卧为人扶加官\n" +
                "病重者主有凶事 自疾病者主有喜 病人歌唱主大凶 病人哭笑疾病除\n" +
                "病人起者必定起 病人装车必死亡 死人哭泣有口舌 死人立者主大凶\n" +
                "死人哭坏者得财 死人复活主有信 见人死自死皆吉 子死者主添喜事\n" +
                "见死亡尊长大吉 门吊他人主生子",
                //原版周公解梦之 十九、佛道 僧尼 鬼神\n" +
                "诸佛菩萨大吉利 法师登座有疾病 老君真人皆主吉 画神佛者得人钦\n" +
                "看神佛者妻有子 佛共人言有福助 入神庙神动大吉 道施盖者大吉利\n" +
                "憎师教人念经吉 道士女冠言语吉 和尚尼姑看以闷 被鬼神打大不祥\n" +
                "堂上神佛大吉利 神佛不成行大凶 烧香礼拜皆大吉 迎神赛社有外财\n" +
                "仙圣到家福禄至 与鬼斗者主延寿 祭祀神道大吉利 身受戒行者子孝\n" +
                "与神女通得贵子 与尼姑交主失财",
                //原版周公解梦之 二十、杀害 斗伤 打骂\n" +
                "被人打害者大吉 杀死他人人富贵 持刀自杀者大吉 杀人血污衣得财\n" +
                "被刀刺尖出快利 持刀相杀见血吉 刀伤出血主酒食 砍刺见血主大吉\n" +
                "炙身见血流大吉 刀斧自伤主大吉 持刀砍人自失力 被妻妾打者主凶\n" +
                "被人打者主得力 女人相打主病至 兄弟相打大吉利 家中人斗主分散\n" +
                "看见杀人主大吉 被人签刺大吉昌 手指折者主子病 向人叩头百事吉\n" +
                "与人相骂者主吉 被骂佯颠大贵至 被人凌辱主得财 杀猪者大吉利\n" +
                "杀驴骡马有酒食 杀龟者主有丧事 杀鸟雀妻妾灾难 杀鸡鹅鸭主大吉",
                //原版周公解梦之 二十一、扑禁 刑罚 狱具\n" +
                "牢狱崩坏有赦吉 坐狱中必有恩赦 入狱受灾主荣贵 狱中死者官事散\n" +
                "使人入狱得财吉 入牢狱主有大贵 盗曲自入狱大凶 牢狱臭污百事吉\n" +
                "罪人走脱疾病去 赶贼行见者大吉 枷锁临身疾病至 枷锁折损口舌散\n" +
                "枷锁入宅主大凶 绳索系身大吉利 身被罗网主官事 被罗网罩主酒食\n" +
                "被人疾罚禄位至 被人作贱者大吉 被官打身主孝服 被人绑主疾病至\n" +
                "自以杖决耻辱生 枷锁恐怖主分散 邀人入官主酒食 入官词议主大吉\n" +
                "吏引入司主大吉 为吏所录有急事 贵人走马官事明 拷讯杖责主大贵",
                //原版周公解梦之 二十二、田园 五谷 耕种\n" +
                "田中生草主得财 种田宽大有禄位 自种田禾主出行 见种田者禄位至\n" +
                "教人耕种远行至 使人种田地大吉 买人田宅主进职 身在禾中大吉利\n" +
                "破败田地主大吉 割收田禾家已安 屋上生禾官位吉 见禾丰熟富贵长\n" +
                "见麦稻主得大财 粳糯米者有财吉 五谷茂盛主得财 谷穗齐秀大吉利\n" +
                "米谷堆吉散主凶 大小麦主妻私心 大豆苗叶子孙凶 米麦相排大吉利\n" +
                "坐卧米麦主大吉 手中把谷主福禄 得米谷者主大吉 种菜主长命大吉\n" +
                "得禾忽失主得秩 粟米必有献物至 荞麦面饼官事至 麸糠相交家欲检\n" +
                "酒曲必主枉曲事 葫芦者主恶事连 麻丛身者主病至 麻生如林大吉利",
                //原版周公解梦之 二十三、水火 盗贼 灯烛\n" +
                "水上行者主大吉 水上立者主凶事 水流洋洋有新婚 水上火出主大吉\n" +
                "自在水中大吉利 自落水中不出凶 饮水不休得大财 流水绕身有狱讼\n" +
                "大水澄清大吉祥 人家有水见子亡 江海涨漫大吉昌 河水砂石益文章\n" +
                "火烧日月大人助 火烧河水长命吉 火烧山野大显达 火烧自是主兴旺\n" +
                "火焰炎炎主发财 火从地生疾病至 执火乘行官位至 大火烧天主国安\n" +
                "身在火中贵人扶 火烟黑色主疾病 把火行路不通达 把火烧井主病至\n" +
                "赶贼入市不出凶 强贼入宅主家破 与贼同行大吉利 己身做喊所求得",
                //原版周公解梦之 二十四、污垢 沐浴 凌辱\n" +
                "屎尿污身主得财 大使满地主富贵 患厕中得官禄位 落厕出吉不出凶\n" +
                "厕屋上卧主得财 厕中干者主家破 架厕屋主有财喜 挑粪回家大吉利\n" +
                "在泥中所求不成 失大小便主失财 泥污衣裳主产凶 泥污衫衣主身辱\n" +
                "男女沐浴上床凶 沐浴尘土疾病安 洗头迁居疾病除 被辱骂惹人词讼",
                //原版周公解梦之 二十五、龙蛇 禽兽 等类\n" +
                "乘龙入水有贵位 龙眠水中求事通 龙当门者大吉昌 龙死亡主失贵位\n" +
                "乘龙上山所求遂 龙入井中官被辱 龙飞有官位大贵 乘龙上市主贵位\n" +
                "龙蛇入门主得财 龙蛇入灶有官至 蛇化龙行贵人助 妇人见龙生贵子\n" +
                "龙蛇杀人主大凶 蛇咬人主得大财 蛇入怀中生贵子 蛇行水内主迁荣\n" +
                "蛇随人去妻外心 蛇入谷道主口舌 蛇绕身者生贵子 蛇多者主阴司事\n" +
                "蛇赤黑主口舌吉 蛇黄白主有官事 凤凰主有贵人助 凤集拳上母病到\n" +
                "孔雀者主大吉利 鹤上天主小口灾 鹤鸣着禄位大显 鹤入怀中生贵子\n" +
                "鹤驾车主征伐事 放鹤者主得财吉 孔雀飞舞有文章 鹦鹉妇人主口舌\n" +
                "鸳鸯散去夫妻凶 野鸭入宅主有凶 驾鹞者主禄位至 鸠鸽者妇人有喜\n" +
                "燕飞入怀妻生子 燕子至有远客来 空中鸟鸣主妻亡 飞鸟人怀皆主吉\n" +
                "捉住飞鸟远信至 雀相争斗有官事 鸦雀相噪主酒食 鹅鸭同游添好妾\n" +
                "鸟走蛇来人引荐 洗鸡得官鸣口舌 鸡抱卵主有大喜 鸡在树上主得财\n" +
                "麒麟者名震天下 白象江猪官位至 狮子叫吼场名震 猛虎大吼主得官\n" +
                "骑虎行者恶事无 虎入宅中官职重 虎狼不动见官吉 豺狼恶狗有盗贼\n" +
                "狼啖脚者主不行 骆驼豹豸得重印 熊罢主身生贵子 群免上天得贵位\n" +
                "獐鹿在家益官禄 浩鬼在园百忧去 猫捕鼠者主得财 白鼠引路人提携\n" +
                "鼠咬人衣所求得 鼠大走主有善事 山猴有争讼事端 白猿主有禄位得",
                //原版周公解梦之 二十六、牛马 猪羊 六畜\n" +
                "黄牛来家大富贵 水牛主先祖索食 牛上同坡大吉昌 牵牛上山主富贵\n" +
                "牛角有血主三公 牛触人心事不成 牛出门好事立至 水牛来家主丧事\n" +
                "牛主犊所求皆得 骑牛入城有喜临 牵牛羊来家欢乐 马舞庭前凶事散\n" +
                "马行千里大喜至 乘马快喜饨主凶 走马来往文书事 马入室主奸情事\n" +
                "乌蛇践物失禄位 披洗夜马皆喜事 群马奔统百凶解 罪人走马厄事会\n" +
                "乘白马者主疾病 被马咬有禄位至 骑驴骡主得财吉 杀猪吉猪自死凶\n" +
                "猪豚变人官事至 猪羊搔痒有口舌 羊做豚行行人至 骑羊上街主得财\n" +
                "子母羊益命大吉 犬吠人鬼来求食 犬咬主人失财凶 屋中生马主大吉",
                //原版周公解梦之 二十七、龟鳖 鱼虾 昆虫\n" +
                "龟入井宅富贵至 龟蛇相同主生财 见龟者主女人贵 捉龟者主丧事至\n" +
                "见鳖者主有得财 鱼飞水上百事散 井内有鱼迁官至 张网捕鱼大吉利\n" +
                "人捕鱼作食皆吉 抢鱼拾鱼主小疾 水中钓鱼大吉利 林中鱼猪事无成\n" +
                "群鱼游水主有财 鲤鱼妻有孕大吉 大鱼扬动主声名 小鱼生子大吉利\n" +
                "干鱼下水命复通 虾变鱼主失财物 身坐鱼虫病患除 螃蟹主百病消散\n" +
                "蛤蟆鸣走有口舌 水蛭主女人失财 螺狮生在外不利 蛤蜊主老来生子\n" +
                "飞娥入灯他人败 蚕飞不茧主小吉 峰蜈交戏事不成 峰螫人脚有财喜\n" +
                "恙螂作堆主失财 蜻蜓对飞美人来 促织声繁有小吉 蝙蝠群飞明事良\n" +
                "蝇污人衣必有谗 蝼蛄主有不明事"  );


        return list;
    }




}