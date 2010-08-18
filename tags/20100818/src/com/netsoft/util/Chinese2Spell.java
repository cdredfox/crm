package com.netsoft.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 * 
 * @作者 　　杨飞（猪崽崽）
 * @工程名　NetSoftCRM
 * @文件名　Chinese2Spell.java
 * @编写日期　Dec 23, 2006
 * @功能说明　根据中文取相应的拼音。。工具类。
 */
public class Chinese2Spell {
	private static LinkedHashMap hm=null; /**用来存放拼间简码与对应ASCII的值*/
	//静态块用来初始化哈希表的值
	static{
		if(hm==null)
		{
			hm=new LinkedHashMap(400);
		}
		init();
	}
	
	//给哈希表put值的方法
	private static void spellPut(String spell,int ascii)
	{
		hm.put(spell, new Integer(ascii));
	}
	
	/**
	 * 
	 * @功能说明　用来初始化哈希表.存放拼音对应的ASCII码
	 * @返回类型　void
	 */
	private static void init()
	{
		spellPut("a", -20319);
	    spellPut("ai", -20317);
	    spellPut("an", -20304);
	    spellPut("ang", -20295);
	    spellPut("ao", -20292);
	    spellPut("ba", -20283);
	    spellPut("bai", -20265);
	    spellPut("ban", -20257);
	    spellPut("bang", -20242);
	    spellPut("bao", -20230);
	    spellPut("bei", -20051);
	    spellPut("ben", -20036);
	    spellPut("beng", -20032);
	    spellPut("bi", -20026);
	    spellPut("bian", -20002);
	    spellPut("biao", -19990);
	    spellPut("bie", -19986);
	    spellPut("bin", -19982);
	    spellPut("bing", -19976);
	    spellPut("bo", -19805);
	    spellPut("bu", -19784);
	    spellPut("ca", -19775);
	    spellPut("cai", -19774);
	    spellPut("can", -19763);
	    spellPut("cang", -19756);
	    spellPut("cao", -19751);
	    spellPut("ce", -19746);
	    spellPut("ceng", -19741);
	    spellPut("cha", -19739);
	    spellPut("chai", -19728);
	    spellPut("chan", -19725);
	    spellPut("chang", -19715);
	    spellPut("chao", -19540);
	    spellPut("che", -19531);
	    spellPut("chen", -19525);
	    spellPut("cheng", -19515);
	    spellPut("chi", -19500);
	    spellPut("chong", -19484);
	    spellPut("chou", -19479);
	    spellPut("chu", -19467);
	    spellPut("chuai", -19289);
	    spellPut("chuan", -19288);
	    spellPut("chuang", -19281);
	    spellPut("chui", -19275);
	    spellPut("chun", -19270);
	    spellPut("chuo", -19263);
	    spellPut("ci", -19261);
	    spellPut("cong", -19249);
	    spellPut("cou", -19243);
	    spellPut("cu", -19242);
	    spellPut("cuan", -19238);
	    spellPut("cui", -19235);
	    spellPut("cun", -19227);
	    spellPut("cuo", -19224);
	    spellPut("da", -19218);
	    spellPut("dai", -19212);
	    spellPut("dan", -19038);
	    spellPut("dang", -19023);
	    spellPut("dao", -19018);
	    spellPut("de", -19006);
	    spellPut("deng", -19003);
	    spellPut("di", -18996);
	    spellPut("dian", -18977);
	    spellPut("diao", -18961);
	    spellPut("die", -18952);
	    spellPut("ding", -18783);
	    spellPut("diu", -18774);
	    spellPut("dong", -18773);
	    spellPut("dou", -18763);
	    spellPut("du", -18756);
	    spellPut("duan", -18741);
	    spellPut("dui", -18735);
	    spellPut("dun", -18731);
	    spellPut("duo", -18722);
	    spellPut("e", -18710);
	    spellPut("en", -18697);
	    spellPut("er", -18696);
	    spellPut("fa", -18526);
	    spellPut("fan", -18518);
	    spellPut("fang", -18501);
	    spellPut("fei", -18490);
	    spellPut("fen", -18478);
	    spellPut("feng", -18463);
	    spellPut("fo", -18448);
	    spellPut("fou", -18447);
	    spellPut("fu", -18446);
	    spellPut("ga", -18239);
	    spellPut("gai", -18237);
	    spellPut("gan", -18231);
	    spellPut("gang", -18220);
	    spellPut("gao", -18211);
	    spellPut("ge", -18201);
	    spellPut("gei", -18184);
	    spellPut("gen", -18183);
	    spellPut("geng", -18181);
	    spellPut("gong", -18012);
	    spellPut("gou", -17997);
	    spellPut("gu", -17988);
	    spellPut("gua", -17970);
	    spellPut("guai", -17964);
	    spellPut("guan", -17961);
	    spellPut("guang", -17950);
	    spellPut("gui", -17947);
	    spellPut("gun", -17931);
	    spellPut("guo", -17928);
	    spellPut("ha", -17922);
	    spellPut("hai", -17759);
	    spellPut("han", -17752);
	    spellPut("hang", -17733);
	    spellPut("hao", -17730);
	    spellPut("he", -17721);
	    spellPut("hei", -17703);
	    spellPut("hen", -17701);
	    spellPut("heng", -17697);
	    spellPut("hong", -17692);
	    spellPut("hou", -17683);
	    spellPut("hu", -17676);
	    spellPut("hua", -17496);
	    spellPut("huai", -17487);
	    spellPut("huan", -17482);
	    spellPut("huang", -17468);
	    spellPut("hui", -17454);
	    spellPut("hun", -17433);
	    spellPut("huo", -17427);
	    spellPut("ji", -17417);
	    spellPut("jia", -17202);
	    spellPut("jian", -17185);
	    spellPut("jiang", -16983);
	    spellPut("jiao", -16970);
	    spellPut("jie", -16942);
	    spellPut("jin", -16915);
	    spellPut("jing", -16733);
	    spellPut("jiong", -16708);
	    spellPut("jiu", -16706);
	    spellPut("ju", -16689);
	    spellPut("juan", -16664);
	    spellPut("jue", -16657);
	    spellPut("jun", -16647);
	    spellPut("ka", -16474);
	    spellPut("kai", -16470);
	    spellPut("kan", -16465);
	    spellPut("kang", -16459);
	    spellPut("kao", -16452);
	    spellPut("ke", -16448);
	    spellPut("ken", -16433);
	    spellPut("keng", -16429);
	    spellPut("kong", -16427);
	    spellPut("kou", -16423);
	    spellPut("ku", -16419);
	    spellPut("kua", -16412);
	    spellPut("kuai", -16407);
	    spellPut("kuan", -16403);
	    spellPut("kuang", -16401);
	    spellPut("kui", -16393);
	    spellPut("kun", -16220);
	    spellPut("kuo", -16216);
	    spellPut("la", -16212);
	    spellPut("lai", -16205);
	    spellPut("lan", -16202);
	    spellPut("lang", -16187);
	    spellPut("lao", -16180);
	    spellPut("le", -16171);
	    spellPut("lei", -16169);
	    spellPut("leng", -16158);
	    spellPut("li", -16155);
	    spellPut("lia", -15959);
	    spellPut("lian", -15958);
	    spellPut("liang", -15944);
	    spellPut("liao", -15933);
	    spellPut("lie", -15920);
	    spellPut("lin", -15915);
	    spellPut("ling", -15903);
	    spellPut("liu", -15889);
	    spellPut("long", -15878);
	    spellPut("lou", -15707);
	    spellPut("lu", -15701);
	    spellPut("lv", -15681);
	    spellPut("luan", -15667);
	    spellPut("lue", -15661);
	    spellPut("lun", -15659);
	    spellPut("luo", -15652);
	    spellPut("ma", -15640);
	    spellPut("mai", -15631);
	    spellPut("man", -15625);
	    spellPut("mang", -15454);
	    spellPut("mao", -15448);
	    spellPut("me", -15436);
	    spellPut("mei", -15435);
	    spellPut("men", -15419);
	    spellPut("meng", -15416);
	    spellPut("mi", -15408);
	    spellPut("mian", -15394);
	    spellPut("miao", -15385);
	    spellPut("mie", -15377);
	    spellPut("min", -15375);
	    spellPut("ming", -15369);
	    spellPut("miu", -15363);
	    spellPut("mo", -15362);
	    spellPut("mou", -15183);
	    spellPut("mu", -15180);
	    spellPut("na", -15165);
	    spellPut("nai", -15158);
	    spellPut("nan", -15153);
	    spellPut("nang", -15150);
	    spellPut("nao", -15149);
	    spellPut("ne", -15144);
	    spellPut("nei", -15143);
	    spellPut("nen", -15141);
	    spellPut("neng", -15140);
	    spellPut("ni", -15139);
	    spellPut("nian", -15128);
	    spellPut("niang", -15121);
	    spellPut("niao", -15119);
	    spellPut("nie", -15117);
	    spellPut("nin", -15110);
	    spellPut("ning", -15109);
	    spellPut("niu", -14941);
	    spellPut("nong", -14937);
	    spellPut("nu", -14933);
	    spellPut("nv", -14930);
	    spellPut("nuan", -14929);
	    spellPut("nue", -14928);
	    spellPut("nuo", -14926);
	    spellPut("o", -14922);
	    spellPut("ou", -14921);
	    spellPut("pa", -14914);
	    spellPut("pai", -14908);
	    spellPut("pan", -14902);
	    spellPut("pang", -14894);
	    spellPut("pao", -14889);
	    spellPut("pei", -14882);
	    spellPut("pen", -14873);
	    spellPut("peng", -14871);
	    spellPut("pi", -14857);
	    spellPut("pian", -14678);
	    spellPut("piao", -14674);
	    spellPut("pie", -14670);
	    spellPut("pin", -14668);
	    spellPut("ping", -14663);
	    spellPut("po", -14654);
	    spellPut("pu", -14645);
	    spellPut("qi", -14630);
	    spellPut("qia", -14594);
	    spellPut("qian", -14429);
	    spellPut("qiang", -14407);
	    spellPut("qiao", -14399);
	    spellPut("qie", -14384);
	    spellPut("qin", -14379);
	    spellPut("qing", -14368);
	    spellPut("qiong", -14355);
	    spellPut("qiu", -14353);
	    spellPut("qu", -14345);
	    spellPut("quan", -14170);
	    spellPut("que", -14159);
	    spellPut("qun", -14151);
	    spellPut("ran", -14149);
	    spellPut("rang", -14145);
	    spellPut("rao", -14140);
	    spellPut("re", -14137);
	    spellPut("ren", -14135);
	    spellPut("reng", -14125);
	    spellPut("ri", -14123);
	    spellPut("rong", -14122);
	    spellPut("rou", -14112);
	    spellPut("ru", -14109);
	    spellPut("ruan", -14099);
	    spellPut("rui", -14097);
	    spellPut("run", -14094);
	    spellPut("ruo", -14092);
	    spellPut("sa", -14090);
	    spellPut("sai", -14087);
	    spellPut("san", -14083);
	    spellPut("sang", -13917);
	    spellPut("sao", -13914);
	    spellPut("se", -13910);
	    spellPut("sen", -13907);
	    spellPut("seng", -13906);
	    spellPut("sha", -13905);
	    spellPut("shai", -13896);
	    spellPut("shan", -13894);
	    spellPut("shang", -13878);
	    spellPut("shao", -13870);
	    spellPut("she", -13859);
	    spellPut("shen", -13847);
	    spellPut("sheng", -13831);
	    spellPut("shi", -13658);
	    spellPut("shou", -13611);
	    spellPut("shu", -13601);
	    spellPut("shua", -13406);
	    spellPut("shuai", -13404);
	    spellPut("shuan", -13400);
	    spellPut("shuang", -13398);
	    spellPut("shui", -13395);
	    spellPut("shun", -13391);
	    spellPut("shuo", -13387);
	    spellPut("si", -13383);
	    spellPut("song", -13367);
	    spellPut("sou", -13359);
	    spellPut("su", -13356);
	    spellPut("suan", -13343);
	    spellPut("sui", -13340);
	    spellPut("sun", -13329);
	    spellPut("suo", -13326);
	    spellPut("ta", -13318);
	    spellPut("tai", -13147);
	    spellPut("tan", -13138);
	    spellPut("tang", -13120);
	    spellPut("tao", -13107);
	    spellPut("te", -13096);
	    spellPut("teng", -13095);
	    spellPut("ti", -13091);
	    spellPut("tian", -13076);
	    spellPut("tiao", -13068);
	    spellPut("tie", -13063);
	    spellPut("ting", -13060);
	    spellPut("tong", -12888);
	    spellPut("tou", -12875);
	    spellPut("tu", -12871);
	    spellPut("tuan", -12860);
	    spellPut("tui", -12858);
	    spellPut("tun", -12852);
	    spellPut("tuo", -12849);
	    spellPut("wa", -12838);
	    spellPut("wai", -12831);
	    spellPut("wan", -12829);
	    spellPut("wang", -12812);
	    spellPut("wei", -12802);
	    spellPut("wen", -12607);
	    spellPut("weng", -12597);
	    spellPut("wo", -12594);
	    spellPut("wu", -12585);
	    spellPut("xi", -12556);
	    spellPut("xia", -12359);
	    spellPut("xian", -12346);
	    spellPut("xiang", -12320);
	    spellPut("xiao", -12300);
	    spellPut("xie", -12120);
	    spellPut("xin", -12099);
	    spellPut("xing", -12089);
	    spellPut("xiong", -12074);
	    spellPut("xiu", -12067);
	    spellPut("xu", -12058);
	    spellPut("xuan", -12039);
	    spellPut("xue", -11867);
	    spellPut("xun", -11861);
	    spellPut("ya", -11847);
	    spellPut("yan", -11831);
	    spellPut("yang", -11798);
	    spellPut("yao", -11781);
	    spellPut("ye", -11604);
	    spellPut("yi", -11589);
	    spellPut("yin", -11536);
	    spellPut("ying", -11358);
	    spellPut("yo", -11340);
	    spellPut("yong", -11339);
	    spellPut("you", -11324);
	    spellPut("yu", -11303);
	    spellPut("yuan", -11097);
	    spellPut("yue", -11077);
	    spellPut("yun", -11067);
	    spellPut("za", -11055);
	    spellPut("zai", -11052);
	    spellPut("zan", -11045);
	    spellPut("zang", -11041);
	    spellPut("zao", -11038);
	    spellPut("ze", -11024);
	    spellPut("zei", -11020);
	    spellPut("zen", -11019);
	    spellPut("zeng", -11018);
	    spellPut("zha", -11014);
	    spellPut("zhai", -10838);
	    spellPut("zhan", -10832);
	    spellPut("zhang", -10815);
	    spellPut("zhao", -10800);
	    spellPut("zhe", -10790);
	    spellPut("zhen", -10780);
	    spellPut("zheng", -10764);
	    spellPut("zhi", -10587);
	    spellPut("zhong", -10544);
	    spellPut("zhou", -10533);
	    spellPut("zhu", -10519);
	    spellPut("zhua", -10331);
	    spellPut("zhuai", -10329);
	    spellPut("zhuan", -10328);
	    spellPut("zhuang", -10322);
	    spellPut("zhui", -10315);
	    spellPut("zhun", -10309);
	    spellPut("zhuo", -10307);
	    spellPut("zi", -10296);
	    spellPut("zong", -10281);
	    spellPut("zou", -10274);
	    spellPut("zu", -10270);
	    spellPut("zuan", -10262);
	    spellPut("zui", -10260);
	    spellPut("zun", -10256);
	    spellPut("zuo", -10254);
	}
	
	/**
	 * 
	 * @功能说明　根据传进来的字符得到字符对应的ASCII码
	 * @返回类型　int
	 * @param cn
	 * @return
	 */
     public static int getAsciiByCN(char cn)
     { 
    	try {
//    		将传进来的字符化成字符数组.用来检查是英文还是中文.因为英文
       	 //占一个字节.而汉字占两个
       	 byte[] bytecn=String.valueOf(cn).getBytes();
       	 //如果大于2或者小于1或者为空.则有错.不是字符
       	 if(bytecn==null||bytecn.length<1||bytecn.length>2)
       	 {
       		 return 0;
       	 }
       	 if(bytecn.length==1)
       	 {
       		 return bytecn[0];//英文直接返回
       	 }else
       	 {
       		 //下面是得到汉字ASCII的算法. 
       		 int hightByte = 256 + bytecn[0];
       	     int lowByte = 256 + bytecn[1];
       	     int ascii = (256 * hightByte + lowByte) - 256 * 256;
       	     return ascii;
       	 }
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	 
     }
     
     /**
      * 
      * @功能说明　根据值.到哈希表中去找对应的拼音
      * @返回类型　int
      * @param ascii
      * @return
      */
     public static String getSpellByAscii(int ascii)
     {
    	 if(ascii > 0 && ascii < 160){ //单个字符直接返回
    	      return String.valueOf((char)ascii);
    	    }

    	    if(ascii < -20319 || ascii > -10247){ //不知道的字符
    	      return null;
    	    }

    	    Set keySet = hm.keySet(); //取得KEY集合
    	    Iterator it = keySet.iterator(); //得到迭代器

    	    String spell0 = null;
    	    String spell = null;//保存返回得到的拼音

    	    int asciiRang0 = -20319;//有效字符的区间的最大值
    	    System.out.println(asciiRang0);
    	    int asciiRang;//当前字符的ascii的值
    	    while(it.hasNext()){
    	      spell = (String)it.next();
    	     // System.out.println(asciiRang0+"   "+spell);
    	     // Object valObj = hm.get(spell);
    	      //if(valObj instanceof Integer){
    	       // asciiRang = ((Integer)valObj).intValue();
                asciiRang=(Integer) hm.get(spell);
                
    	        if(ascii >= asciiRang0 && ascii < asciiRang){ //区间找到
    	        	//传进来的值:-12590  上限值:-12594  新值: -12585
    	        	//System.out.println("传进来的值:"+ascii+"  上限值:"+asciiRang0+"  "+"新值: "+asciiRang);
    	        	return(spell0 == null) ? spell : spell0;
    	        }
    	        else{
    	          spell0 = spell;
    	          asciiRang0 = asciiRang;
    	        }
    	     // }
    	    }
    	    return null;
     }
     
     /**
      * 
      * @功能说明　根据句子取完整的拼音
      * @返回类型　String
      * @param cn
      * @return
      */
     public static String getSpellByCN(String cn)
     {
    	 StringBuffer sb=new StringBuffer();
    	 if(cn==null ||"".equals(cn))
    	 {
    		 return cn;
    	 }
    	 char[] c=cn.toCharArray();
    	 int length=c.length;
    	 for(int i=0;i<length;i++)
    	 {
    		 int ascii=getAsciiByCN(c[i]);
    		 if(ascii==0) //如果出错,返回零.代表是未知字符,则直接加到字符串中.
    		 {
    			 sb.append(c[i]);
    		 }else
    		 {
    			String spell=getSpellByAscii(ascii);
    		    if(spell==null) //如果出错.返回null.则将没有转换的字符直接放到字符串中
    		    {
    		    	sb.append(c[i]);
    		    }else
    		    {
    		    	sb.append(spell);
    		    }
    		 }
    	 }
    	 return sb.toString();
     }
     
     /**
      * 
      * @功能说明　要据句子取每个汉字的拼音的第一个字母(此方法只能用于中文)
      * @返回类型　void
      * @param args
      */
     public static String getStartSpellByCN(String cn)
     {
    	 StringBuffer sb=new StringBuffer();
    	 if(cn==null || "".equals(cn))
    	 {
    		 return cn;
    	 }
    	 char[] c=cn.toCharArray();
    	 int length=c.length;
    	 for(int i=0;i<length;i++)
    	 {
    		 int ascii=getAsciiByCN(c[i]);
    		 if(ascii==0) //如果出错
    		 {
    			 sb.append(c[i]);
    		 }else
    		 {
    			 String spell=getSpellByAscii(ascii);
    			 if(spell==null) //如果出错
    			 {
    				 sb.append(c[i]);
    			 }else
    			 {
    				 
    				 sb.append(spell.charAt(0)); //取拼音的第一个字母
    			 }
    		 }
    	 }
    	 return sb.toString();
     }
     
     public static void main(String[] args) {
 		//System.out.println(CN2EN.getAsciiByCN('羊'));
 		//System.out.println(("中华人民共和国".toCharArray())[2]);
 		//System.out.println(CN2EN.getStartSpellByCN("我爱中国,中国爱我,我爱所有的人"));
 		System.out.println(Chinese2Spell.getSpellByCN("我"));

      }
}
