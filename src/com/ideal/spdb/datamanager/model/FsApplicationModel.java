package com.ideal.spdb.datamanager.model;

import com.ideal.spdb.utils.BaseModel;

/**    
 * @author wls  
 * @date 2012-11-16
 * @version V1.0   
 * @description 附属进件表
 */
public class FsApplicationModel extends BaseModel {

	private String applicationfsid;		//进件表和附属表关联id
	private String fsapplicationid;		//附属表主键id
	private String fsyinhang;		//银行
	private String fsshenqingshubianhao;		//申请书编号
	private String fsfukaeduzhanzhukaedubaifenbi;		//附卡额度占主卡额度百分比
	private String fsfukagudingxinyongedu;		//附卡固定信用额
	private String fsshenqingrenzhengjianleixing;		//申请人证件类型
	private String fsshenqingrenzhengjianhaoma;		//申请人证件号码
	private String fsshenqingrenshebaokahao;		//申请人社保卡号
	private String fsshenqingrenzhongwenxm;		//申请人中文姓名
	private String fsshenqingrenzhongwenxmpy;		//申请人中文姓名拼音
	private String fsshenqingrenyingwenxingming;		//申请人英文姓名
	private String fsshenqingrenxingbie;		//申请人性别
	private String fsshenqingrenchushengriqi;		//申请人出生日期
	private String fsshenqingrenguoji;		//申请人国籍
	private String fsshenqingrenhunyinzk;		//申请人婚姻状况
	private String fsshenqingrenjiaoyuchengdu;		//申请人教育程度
	private String fsshenqingrengangwei;		//申请人岗位
	private String fsshenqingrenzhicheng;		//申请人职称
	private String fsgongzuozhiye;		//工作职业
	private String fsshenqingrenyuyandaima;		//申请人语言代码
	private String fsshenqingrenjiatingdianhuaqh;		//申请人家庭电话区号
	private String fsshenqingrenjiatingdianhua;		//申请人家庭电话
	private String fsshenqingrenshoujihaoma;		//申请人手机号码
	private String fsshenqingrenemaildizhi;		//申请人e-mail地址
	private String fsshenqingrenchuanzhenhaoma;		//申请人传真号码
	private String fsshifouzhaopianka;		//是否照片卡
	private String fsshenqingrenkehuleibie;		//申请人客户类别
	private String fsjiatingfangwuzhuangkuang;		//家庭房屋状况
	private String fsjuzhunianshu;		//居住年数
	private String fsyuehuankuane;		//月还款额/月租金额
	private String fsyinhangxinxi;		//银行信息
	private String fsshifoujieshoudianhuaxuewen;		//是否接受电话询问
	private String fsshifoujieshouxinjian;		//是否接受信件
	private String fscaichanzhengmingleixing;		//财产证明类型
	private String fscaichanjiazhi;		//财产价值
	private String fscaichanhuoquriqi;		//财产获取日期
	private String fscaichanzhengmingleixing2;		//财产证明类型_2
	private String fscaichanjiazhi2;		//财产价值_2
	private String fscaichanhuoquriqi2;		//财产获取日期_2
	private String fszonggongling;		//总工龄
	private String fspufayinhangkehu;		//浦发银行客户
	private String fsyichiyoubenhangchanpin;		//已持有本行产品
	private String fschengweibenhangkehushijian;		//成为本行客户时间
	private String fsshenqingrenyubenhangwlgx;		//申请人与本行往来关系
	private String fsjiatingfangwugoufangjiage;		//家庭房屋购房价格
	private String fsjiatingfangwudaiguannx;		//家庭房屋贷款年限
	private String fszigoucheliangpinpai;		//自购车辆品牌
	private String fszigouchelianggoumaishijian;		//自购车辆购买时间
	private String fszigoucheliangchepaihao;		//自购车辆车牌号
	private String fszigoucheliangqingkuang;		//自购车辆情况
	private String fszigoucheliangzongjine;		//自购车辆总金额
	private String fszigoucheliangyuehuankuane;		//自购车辆月还款额
	private String fsgongsizhongwenmingcheng;		//公司中文名称
	private String fsgongsibumen;		//公司部门
	private String fsgongsizhiwu;		//公司职务
	private String fsgongsihangyeleibiema;		//公司行业类别码
	private String fsgongsixinzhi;		//公司性质
	private String fsgongsiguimo;		//公司规模
	private String fsgongsidianhuaquhao;		//公司电话区号
	private String fsgongsidianhua;		//公司电话
	private String fsgongsidianhuafeiji;		//公司电话分机
	private String fsqitadianhuaquhao;		//其他电话区号
	private String fsqitadianhua;		//其他电话
	private String fsqitadianhuafeiji;		//其他电话分机
	private String fsgongsifuwunianshu;		//公司服务年数
	private String fsshenqingrennianshouru;		//申请人年收入(客户填写)
	private String fsqitashouru;		//其他收入
	private String fsgerenzhuyaoshourulaiyuan;		//个人主要收入来源
	private String fsqitashourulaiyuan;		//其它收入来源
	private String fsqiangongsizhongwenqc;		//前公司中文全称
	private String fsqiangongsizhiwu;		//前公司职务
	private String fsqiangongsizhicheng;		//前公司职称/岗位
	private String fsqiangongsidianhua;		//前公司电话
	private String fsqiangongsifuwunianshu;		//前公司服务年数
	private String fsqiangongsinianshouru;		//前公司年收入
	private String fsqiangongsizhongwenqc2;		//前公司中文全称2
	private String fsqiangongsifuwunianshu2;		//前公司服务年数2
	private String fsqiangongsinianshouru2;		//前公司年收入2
	private String fsshenqingrenfuyangrenshu;		//申请人抚养人数
	private String fsshenqingrenshifouxuyaoslfw;		//申请人是否需要商旅服务
	private String fsshenqingrenyuliuwenti;		//申请人预留问题
	private String fsshenqingrenyuliudaan;		//申请人预留答案
	private String fspeiouzhengjianleixing;		//配偶证件类型
	private String fspeiouzhengjianbianhao;		//配偶证件编号
	private String fspeiouzhongwenxingming;		//配偶中文姓名
	private String fspeioushoujihaoma;		//配偶手机号码
	private String fspeiougongsiquancheng;		//配偶公司全称
	private String fspeiougongsibumen;		//配偶公司部门
	private String fspeiougongsizhiwu;		//配偶公司职务
	private String fspeiougongsidianhua;		//配偶公司电话
	private String fspeiougongsidianhuafenji;		//配偶公司电话分机
	private String fspeiounianshouru;		//配偶年收入
	private String fsshenqingrenqitaxinyongkakh;		//申请人其它信用卡卡号
	private String fsshenqingrenqitaxinyongkalx;		//申请人其它信用卡类型
	private String fsshenqingrenqitaxinyongkxyed;		//申请人其它信用卡信用额度
	private String fsshenqingrentuzixingming;		//申请人凸字姓名
	private String fsxiaofeishifouxuyaomima;		//消费是否需要密码
	private String fskapianbanmiandaima;		//卡片版面代码
	private String fsgongsimingchengtuzi;		//公司名称凸字/会员号
	private String fsshifoudayinmixin;		//是否打印密信？
	private String fsgexingbiaoshima;		//个性标识码
	private String fsfukayuzhukashenqingrengx;		//附卡与主卡申请人关系
	private String fsbaoliuziduan;		//保留字段
	private String fsshenqingrenjiatingdianhuafj;		//申请人家庭电话分机
	private String fszhengjianyouxiaoqi;		//证件有效期
	
	
	
	
	public String getApplicationfsid() {
		return applicationfsid;
	}
	public void setApplicationfsid(String applicationfsid) {
		this.applicationfsid = applicationfsid;
	}
	public String getFsapplicationid() {
		return fsapplicationid;
	}
	public void setFsapplicationid(String fsapplicationid) {
		this.fsapplicationid = fsapplicationid;
	}
	public String getFsyinhang() {
		return fsyinhang;
	}
	public void setFsyinhang(String fsyinhang) {
		this.fsyinhang = fsyinhang;
	}
	public String getFsshenqingshubianhao() {
		return fsshenqingshubianhao;
	}
	public void setFsshenqingshubianhao(String fsshenqingshubianhao) {
		this.fsshenqingshubianhao = fsshenqingshubianhao;
	}
	public String getFsfukaeduzhanzhukaedubaifenbi() {
		return fsfukaeduzhanzhukaedubaifenbi;
	}
	public void setFsfukaeduzhanzhukaedubaifenbi(
			String fsfukaeduzhanzhukaedubaifenbi) {
		this.fsfukaeduzhanzhukaedubaifenbi = fsfukaeduzhanzhukaedubaifenbi;
	}
	public String getFsfukagudingxinyongedu() {
		return fsfukagudingxinyongedu;
	}
	public void setFsfukagudingxinyongedu(String fsfukagudingxinyongedu) {
		this.fsfukagudingxinyongedu = fsfukagudingxinyongedu;
	}
	public String getFsshenqingrenzhengjianleixing() {
		return fsshenqingrenzhengjianleixing;
	}
	public void setFsshenqingrenzhengjianleixing(
			String fsshenqingrenzhengjianleixing) {
		this.fsshenqingrenzhengjianleixing = fsshenqingrenzhengjianleixing;
	}
	public String getFsshenqingrenzhengjianhaoma() {
		return fsshenqingrenzhengjianhaoma;
	}
	public void setFsshenqingrenzhengjianhaoma(String fsshenqingrenzhengjianhaoma) {
		this.fsshenqingrenzhengjianhaoma = fsshenqingrenzhengjianhaoma;
	}
	public String getFsshenqingrenshebaokahao() {
		return fsshenqingrenshebaokahao;
	}
	public void setFsshenqingrenshebaokahao(String fsshenqingrenshebaokahao) {
		this.fsshenqingrenshebaokahao = fsshenqingrenshebaokahao;
	}
	public String getFsshenqingrenzhongwenxm() {
		return fsshenqingrenzhongwenxm;
	}
	public void setFsshenqingrenzhongwenxm(String fsshenqingrenzhongwenxm) {
		this.fsshenqingrenzhongwenxm = fsshenqingrenzhongwenxm;
	}
	public String getFsshenqingrenzhongwenxmpy() {
		return fsshenqingrenzhongwenxmpy;
	}
	public void setFsshenqingrenzhongwenxmpy(String fsshenqingrenzhongwenxmpy) {
		this.fsshenqingrenzhongwenxmpy = fsshenqingrenzhongwenxmpy;
	}
	public String getFsshenqingrenyingwenxingming() {
		return fsshenqingrenyingwenxingming;
	}
	public void setFsshenqingrenyingwenxingming(String fsshenqingrenyingwenxingming) {
		this.fsshenqingrenyingwenxingming = fsshenqingrenyingwenxingming;
	}
	public String getFsshenqingrenxingbie() {
		return fsshenqingrenxingbie;
	}
	public void setFsshenqingrenxingbie(String fsshenqingrenxingbie) {
		this.fsshenqingrenxingbie = fsshenqingrenxingbie;
	}
	public String getFsshenqingrenchushengriqi() {
		return fsshenqingrenchushengriqi;
	}
	public void setFsshenqingrenchushengriqi(String fsshenqingrenchushengriqi) {
		this.fsshenqingrenchushengriqi = fsshenqingrenchushengriqi;
	}
	public String getFsshenqingrenguoji() {
		return fsshenqingrenguoji;
	}
	public void setFsshenqingrenguoji(String fsshenqingrenguoji) {
		this.fsshenqingrenguoji = fsshenqingrenguoji;
	}
	public String getFsshenqingrenhunyinzk() {
		return fsshenqingrenhunyinzk;
	}
	public void setFsshenqingrenhunyinzk(String fsshenqingrenhunyinzk) {
		this.fsshenqingrenhunyinzk = fsshenqingrenhunyinzk;
	}
	public String getFsshenqingrenjiaoyuchengdu() {
		return fsshenqingrenjiaoyuchengdu;
	}
	public void setFsshenqingrenjiaoyuchengdu(String fsshenqingrenjiaoyuchengdu) {
		this.fsshenqingrenjiaoyuchengdu = fsshenqingrenjiaoyuchengdu;
	}
	public String getFsshenqingrengangwei() {
		return fsshenqingrengangwei;
	}
	public void setFsshenqingrengangwei(String fsshenqingrengangwei) {
		this.fsshenqingrengangwei = fsshenqingrengangwei;
	}
	public String getFsshenqingrenzhicheng() {
		return fsshenqingrenzhicheng;
	}
	public void setFsshenqingrenzhicheng(String fsshenqingrenzhicheng) {
		this.fsshenqingrenzhicheng = fsshenqingrenzhicheng;
	}
	public String getFsgongzuozhiye() {
		return fsgongzuozhiye;
	}
	public void setFsgongzuozhiye(String fsgongzuozhiye) {
		this.fsgongzuozhiye = fsgongzuozhiye;
	}
	public String getFsshenqingrenyuyandaima() {
		return fsshenqingrenyuyandaima;
	}
	public void setFsshenqingrenyuyandaima(String fsshenqingrenyuyandaima) {
		this.fsshenqingrenyuyandaima = fsshenqingrenyuyandaima;
	}
	public String getFsshenqingrenjiatingdianhuaqh() {
		return fsshenqingrenjiatingdianhuaqh;
	}
	public void setFsshenqingrenjiatingdianhuaqh(
			String fsshenqingrenjiatingdianhuaqh) {
		this.fsshenqingrenjiatingdianhuaqh = fsshenqingrenjiatingdianhuaqh;
	}
	public String getFsshenqingrenjiatingdianhua() {
		return fsshenqingrenjiatingdianhua;
	}
	public void setFsshenqingrenjiatingdianhua(String fsshenqingrenjiatingdianhua) {
		this.fsshenqingrenjiatingdianhua = fsshenqingrenjiatingdianhua;
	}
	public String getFsshenqingrenshoujihaoma() {
		return fsshenqingrenshoujihaoma;
	}
	public void setFsshenqingrenshoujihaoma(String fsshenqingrenshoujihaoma) {
		this.fsshenqingrenshoujihaoma = fsshenqingrenshoujihaoma;
	}
	public String getFsshenqingrenemaildizhi() {
		return fsshenqingrenemaildizhi;
	}
	public void setFsshenqingrenemaildizhi(String fsshenqingrenemaildizhi) {
		this.fsshenqingrenemaildizhi = fsshenqingrenemaildizhi;
	}
	public String getFsshenqingrenchuanzhenhaoma() {
		return fsshenqingrenchuanzhenhaoma;
	}
	public void setFsshenqingrenchuanzhenhaoma(String fsshenqingrenchuanzhenhaoma) {
		this.fsshenqingrenchuanzhenhaoma = fsshenqingrenchuanzhenhaoma;
	}
	public String getFsshifouzhaopianka() {
		return fsshifouzhaopianka;
	}
	public void setFsshifouzhaopianka(String fsshifouzhaopianka) {
		this.fsshifouzhaopianka = fsshifouzhaopianka;
	}
	public String getFsshenqingrenkehuleibie() {
		return fsshenqingrenkehuleibie;
	}
	public void setFsshenqingrenkehuleibie(String fsshenqingrenkehuleibie) {
		this.fsshenqingrenkehuleibie = fsshenqingrenkehuleibie;
	}
	public String getFsjiatingfangwuzhuangkuang() {
		return fsjiatingfangwuzhuangkuang;
	}
	public void setFsjiatingfangwuzhuangkuang(String fsjiatingfangwuzhuangkuang) {
		this.fsjiatingfangwuzhuangkuang = fsjiatingfangwuzhuangkuang;
	}
	public String getFsjuzhunianshu() {
		return fsjuzhunianshu;
	}
	public void setFsjuzhunianshu(String fsjuzhunianshu) {
		this.fsjuzhunianshu = fsjuzhunianshu;
	}
	public String getFsyuehuankuane() {
		return fsyuehuankuane;
	}
	public void setFsyuehuankuane(String fsyuehuankuane) {
		this.fsyuehuankuane = fsyuehuankuane;
	}
	public String getFsyinhangxinxi() {
		return fsyinhangxinxi;
	}
	public void setFsyinhangxinxi(String fsyinhangxinxi) {
		this.fsyinhangxinxi = fsyinhangxinxi;
	}
	public String getFsshifoujieshoudianhuaxuewen() {
		return fsshifoujieshoudianhuaxuewen;
	}
	public void setFsshifoujieshoudianhuaxuewen(String fsshifoujieshoudianhuaxuewen) {
		this.fsshifoujieshoudianhuaxuewen = fsshifoujieshoudianhuaxuewen;
	}
	public String getFsshifoujieshouxinjian() {
		return fsshifoujieshouxinjian;
	}
	public void setFsshifoujieshouxinjian(String fsshifoujieshouxinjian) {
		this.fsshifoujieshouxinjian = fsshifoujieshouxinjian;
	}
	public String getFscaichanzhengmingleixing() {
		return fscaichanzhengmingleixing;
	}
	public void setFscaichanzhengmingleixing(String fscaichanzhengmingleixing) {
		this.fscaichanzhengmingleixing = fscaichanzhengmingleixing;
	}
	public String getFscaichanjiazhi() {
		return fscaichanjiazhi;
	}
	public void setFscaichanjiazhi(String fscaichanjiazhi) {
		this.fscaichanjiazhi = fscaichanjiazhi;
	}
	public String getFscaichanhuoquriqi() {
		return fscaichanhuoquriqi;
	}
	public void setFscaichanhuoquriqi(String fscaichanhuoquriqi) {
		this.fscaichanhuoquriqi = fscaichanhuoquriqi;
	}
	public String getFscaichanzhengmingleixing2() {
		return fscaichanzhengmingleixing2;
	}
	public void setFscaichanzhengmingleixing2(String fscaichanzhengmingleixing2) {
		this.fscaichanzhengmingleixing2 = fscaichanzhengmingleixing2;
	}
	public String getFscaichanjiazhi2() {
		return fscaichanjiazhi2;
	}
	public void setFscaichanjiazhi2(String fscaichanjiazhi2) {
		this.fscaichanjiazhi2 = fscaichanjiazhi2;
	}
	public String getFscaichanhuoquriqi2() {
		return fscaichanhuoquriqi2;
	}
	public void setFscaichanhuoquriqi2(String fscaichanhuoquriqi2) {
		this.fscaichanhuoquriqi2 = fscaichanhuoquriqi2;
	}
	public String getFszonggongling() {
		return fszonggongling;
	}
	public void setFszonggongling(String fszonggongling) {
		this.fszonggongling = fszonggongling;
	}
	public String getFspufayinhangkehu() {
		return fspufayinhangkehu;
	}
	public void setFspufayinhangkehu(String fspufayinhangkehu) {
		this.fspufayinhangkehu = fspufayinhangkehu;
	}
	public String getFsyichiyoubenhangchanpin() {
		return fsyichiyoubenhangchanpin;
	}
	public void setFsyichiyoubenhangchanpin(String fsyichiyoubenhangchanpin) {
		this.fsyichiyoubenhangchanpin = fsyichiyoubenhangchanpin;
	}
	public String getFschengweibenhangkehushijian() {
		return fschengweibenhangkehushijian;
	}
	public void setFschengweibenhangkehushijian(String fschengweibenhangkehushijian) {
		this.fschengweibenhangkehushijian = fschengweibenhangkehushijian;
	}
	public String getFsshenqingrenyubenhangwlgx() {
		return fsshenqingrenyubenhangwlgx;
	}
	public void setFsshenqingrenyubenhangwlgx(String fsshenqingrenyubenhangwlgx) {
		this.fsshenqingrenyubenhangwlgx = fsshenqingrenyubenhangwlgx;
	}
	public String getFsjiatingfangwugoufangjiage() {
		return fsjiatingfangwugoufangjiage;
	}
	public void setFsjiatingfangwugoufangjiage(String fsjiatingfangwugoufangjiage) {
		this.fsjiatingfangwugoufangjiage = fsjiatingfangwugoufangjiage;
	}
	public String getFsjiatingfangwudaiguannx() {
		return fsjiatingfangwudaiguannx;
	}
	public void setFsjiatingfangwudaiguannx(String fsjiatingfangwudaiguannx) {
		this.fsjiatingfangwudaiguannx = fsjiatingfangwudaiguannx;
	}
	public String getFszigoucheliangpinpai() {
		return fszigoucheliangpinpai;
	}
	public void setFszigoucheliangpinpai(String fszigoucheliangpinpai) {
		this.fszigoucheliangpinpai = fszigoucheliangpinpai;
	}
	public String getFszigouchelianggoumaishijian() {
		return fszigouchelianggoumaishijian;
	}
	public void setFszigouchelianggoumaishijian(String fszigouchelianggoumaishijian) {
		this.fszigouchelianggoumaishijian = fszigouchelianggoumaishijian;
	}
	public String getFszigoucheliangchepaihao() {
		return fszigoucheliangchepaihao;
	}
	public void setFszigoucheliangchepaihao(String fszigoucheliangchepaihao) {
		this.fszigoucheliangchepaihao = fszigoucheliangchepaihao;
	}
	public String getFszigoucheliangqingkuang() {
		return fszigoucheliangqingkuang;
	}
	public void setFszigoucheliangqingkuang(String fszigoucheliangqingkuang) {
		this.fszigoucheliangqingkuang = fszigoucheliangqingkuang;
	}
	public String getFszigoucheliangzongjine() {
		return fszigoucheliangzongjine;
	}
	public void setFszigoucheliangzongjine(String fszigoucheliangzongjine) {
		this.fszigoucheliangzongjine = fszigoucheliangzongjine;
	}
	public String getFszigoucheliangyuehuankuane() {
		return fszigoucheliangyuehuankuane;
	}
	public void setFszigoucheliangyuehuankuane(String fszigoucheliangyuehuankuane) {
		this.fszigoucheliangyuehuankuane = fszigoucheliangyuehuankuane;
	}
	public String getFsgongsizhongwenmingcheng() {
		return fsgongsizhongwenmingcheng;
	}
	public void setFsgongsizhongwenmingcheng(String fsgongsizhongwenmingcheng) {
		this.fsgongsizhongwenmingcheng = fsgongsizhongwenmingcheng;
	}
	public String getFsgongsibumen() {
		return fsgongsibumen;
	}
	public void setFsgongsibumen(String fsgongsibumen) {
		this.fsgongsibumen = fsgongsibumen;
	}
	public String getFsgongsizhiwu() {
		return fsgongsizhiwu;
	}
	public void setFsgongsizhiwu(String fsgongsizhiwu) {
		this.fsgongsizhiwu = fsgongsizhiwu;
	}
	public String getFsgongsihangyeleibiema() {
		return fsgongsihangyeleibiema;
	}
	public void setFsgongsihangyeleibiema(String fsgongsihangyeleibiema) {
		this.fsgongsihangyeleibiema = fsgongsihangyeleibiema;
	}
	public String getFsgongsixinzhi() {
		return fsgongsixinzhi;
	}
	public void setFsgongsixinzhi(String fsgongsixinzhi) {
		this.fsgongsixinzhi = fsgongsixinzhi;
	}
	public String getFsgongsiguimo() {
		return fsgongsiguimo;
	}
	public void setFsgongsiguimo(String fsgongsiguimo) {
		this.fsgongsiguimo = fsgongsiguimo;
	}
	public String getFsgongsidianhuaquhao() {
		return fsgongsidianhuaquhao;
	}
	public void setFsgongsidianhuaquhao(String fsgongsidianhuaquhao) {
		this.fsgongsidianhuaquhao = fsgongsidianhuaquhao;
	}
	public String getFsgongsidianhua() {
		return fsgongsidianhua;
	}
	public void setFsgongsidianhua(String fsgongsidianhua) {
		this.fsgongsidianhua = fsgongsidianhua;
	}
	public String getFsgongsidianhuafeiji() {
		return fsgongsidianhuafeiji;
	}
	public void setFsgongsidianhuafeiji(String fsgongsidianhuafeiji) {
		this.fsgongsidianhuafeiji = fsgongsidianhuafeiji;
	}
	public String getFsqitadianhuaquhao() {
		return fsqitadianhuaquhao;
	}
	public void setFsqitadianhuaquhao(String fsqitadianhuaquhao) {
		this.fsqitadianhuaquhao = fsqitadianhuaquhao;
	}
	public String getFsqitadianhua() {
		return fsqitadianhua;
	}
	public void setFsqitadianhua(String fsqitadianhua) {
		this.fsqitadianhua = fsqitadianhua;
	}
	public String getFsqitadianhuafeiji() {
		return fsqitadianhuafeiji;
	}
	public void setFsqitadianhuafeiji(String fsqitadianhuafeiji) {
		this.fsqitadianhuafeiji = fsqitadianhuafeiji;
	}
	public String getFsgongsifuwunianshu() {
		return fsgongsifuwunianshu;
	}
	public void setFsgongsifuwunianshu(String fsgongsifuwunianshu) {
		this.fsgongsifuwunianshu = fsgongsifuwunianshu;
	}
	public String getFsshenqingrennianshouru() {
		return fsshenqingrennianshouru;
	}
	public void setFsshenqingrennianshouru(String fsshenqingrennianshouru) {
		this.fsshenqingrennianshouru = fsshenqingrennianshouru;
	}
	public String getFsqitashouru() {
		return fsqitashouru;
	}
	public void setFsqitashouru(String fsqitashouru) {
		this.fsqitashouru = fsqitashouru;
	}
	public String getFsgerenzhuyaoshourulaiyuan() {
		return fsgerenzhuyaoshourulaiyuan;
	}
	public void setFsgerenzhuyaoshourulaiyuan(String fsgerenzhuyaoshourulaiyuan) {
		this.fsgerenzhuyaoshourulaiyuan = fsgerenzhuyaoshourulaiyuan;
	}
	public String getFsqitashourulaiyuan() {
		return fsqitashourulaiyuan;
	}
	public void setFsqitashourulaiyuan(String fsqitashourulaiyuan) {
		this.fsqitashourulaiyuan = fsqitashourulaiyuan;
	}
	public String getFsqiangongsizhongwenqc() {
		return fsqiangongsizhongwenqc;
	}
	public void setFsqiangongsizhongwenqc(String fsqiangongsizhongwenqc) {
		this.fsqiangongsizhongwenqc = fsqiangongsizhongwenqc;
	}
	public String getFsqiangongsizhiwu() {
		return fsqiangongsizhiwu;
	}
	public void setFsqiangongsizhiwu(String fsqiangongsizhiwu) {
		this.fsqiangongsizhiwu = fsqiangongsizhiwu;
	}
	public String getFsqiangongsizhicheng() {
		return fsqiangongsizhicheng;
	}
	public void setFsqiangongsizhicheng(String fsqiangongsizhicheng) {
		this.fsqiangongsizhicheng = fsqiangongsizhicheng;
	}
	public String getFsqiangongsidianhua() {
		return fsqiangongsidianhua;
	}
	public void setFsqiangongsidianhua(String fsqiangongsidianhua) {
		this.fsqiangongsidianhua = fsqiangongsidianhua;
	}
	public String getFsqiangongsifuwunianshu() {
		return fsqiangongsifuwunianshu;
	}
	public void setFsqiangongsifuwunianshu(String fsqiangongsifuwunianshu) {
		this.fsqiangongsifuwunianshu = fsqiangongsifuwunianshu;
	}
	public String getFsqiangongsinianshouru() {
		return fsqiangongsinianshouru;
	}
	public void setFsqiangongsinianshouru(String fsqiangongsinianshouru) {
		this.fsqiangongsinianshouru = fsqiangongsinianshouru;
	}
	public String getFsqiangongsizhongwenqc2() {
		return fsqiangongsizhongwenqc2;
	}
	public void setFsqiangongsizhongwenqc2(String fsqiangongsizhongwenqc2) {
		this.fsqiangongsizhongwenqc2 = fsqiangongsizhongwenqc2;
	}
	public String getFsqiangongsifuwunianshu2() {
		return fsqiangongsifuwunianshu2;
	}
	public void setFsqiangongsifuwunianshu2(String fsqiangongsifuwunianshu2) {
		this.fsqiangongsifuwunianshu2 = fsqiangongsifuwunianshu2;
	}
	public String getFsqiangongsinianshouru2() {
		return fsqiangongsinianshouru2;
	}
	public void setFsqiangongsinianshouru2(String fsqiangongsinianshouru2) {
		this.fsqiangongsinianshouru2 = fsqiangongsinianshouru2;
	}
	public String getFsshenqingrenfuyangrenshu() {
		return fsshenqingrenfuyangrenshu;
	}
	public void setFsshenqingrenfuyangrenshu(String fsshenqingrenfuyangrenshu) {
		this.fsshenqingrenfuyangrenshu = fsshenqingrenfuyangrenshu;
	}
	public String getFsshenqingrenshifouxuyaoslfw() {
		return fsshenqingrenshifouxuyaoslfw;
	}
	public void setFsshenqingrenshifouxuyaoslfw(String fsshenqingrenshifouxuyaoslfw) {
		this.fsshenqingrenshifouxuyaoslfw = fsshenqingrenshifouxuyaoslfw;
	}
	public String getFsshenqingrenyuliuwenti() {
		return fsshenqingrenyuliuwenti;
	}
	public void setFsshenqingrenyuliuwenti(String fsshenqingrenyuliuwenti) {
		this.fsshenqingrenyuliuwenti = fsshenqingrenyuliuwenti;
	}
	public String getFsshenqingrenyuliudaan() {
		return fsshenqingrenyuliudaan;
	}
	public void setFsshenqingrenyuliudaan(String fsshenqingrenyuliudaan) {
		this.fsshenqingrenyuliudaan = fsshenqingrenyuliudaan;
	}
	public String getFspeiouzhengjianleixing() {
		return fspeiouzhengjianleixing;
	}
	public void setFspeiouzhengjianleixing(String fspeiouzhengjianleixing) {
		this.fspeiouzhengjianleixing = fspeiouzhengjianleixing;
	}
	public String getFspeiouzhengjianbianhao() {
		return fspeiouzhengjianbianhao;
	}
	public void setFspeiouzhengjianbianhao(String fspeiouzhengjianbianhao) {
		this.fspeiouzhengjianbianhao = fspeiouzhengjianbianhao;
	}
	public String getFspeiouzhongwenxingming() {
		return fspeiouzhongwenxingming;
	}
	public void setFspeiouzhongwenxingming(String fspeiouzhongwenxingming) {
		this.fspeiouzhongwenxingming = fspeiouzhongwenxingming;
	}
	public String getFspeioushoujihaoma() {
		return fspeioushoujihaoma;
	}
	public void setFspeioushoujihaoma(String fspeioushoujihaoma) {
		this.fspeioushoujihaoma = fspeioushoujihaoma;
	}
	public String getFspeiougongsiquancheng() {
		return fspeiougongsiquancheng;
	}
	public void setFspeiougongsiquancheng(String fspeiougongsiquancheng) {
		this.fspeiougongsiquancheng = fspeiougongsiquancheng;
	}
	public String getFspeiougongsibumen() {
		return fspeiougongsibumen;
	}
	public void setFspeiougongsibumen(String fspeiougongsibumen) {
		this.fspeiougongsibumen = fspeiougongsibumen;
	}
	public String getFspeiougongsizhiwu() {
		return fspeiougongsizhiwu;
	}
	public void setFspeiougongsizhiwu(String fspeiougongsizhiwu) {
		this.fspeiougongsizhiwu = fspeiougongsizhiwu;
	}
	public String getFspeiougongsidianhua() {
		return fspeiougongsidianhua;
	}
	public void setFspeiougongsidianhua(String fspeiougongsidianhua) {
		this.fspeiougongsidianhua = fspeiougongsidianhua;
	}
	public String getFspeiougongsidianhuafenji() {
		return fspeiougongsidianhuafenji;
	}
	public void setFspeiougongsidianhuafenji(String fspeiougongsidianhuafenji) {
		this.fspeiougongsidianhuafenji = fspeiougongsidianhuafenji;
	}
	public String getFspeiounianshouru() {
		return fspeiounianshouru;
	}
	public void setFspeiounianshouru(String fspeiounianshouru) {
		this.fspeiounianshouru = fspeiounianshouru;
	}
	public String getFsshenqingrenqitaxinyongkakh() {
		return fsshenqingrenqitaxinyongkakh;
	}
	public void setFsshenqingrenqitaxinyongkakh(String fsshenqingrenqitaxinyongkakh) {
		this.fsshenqingrenqitaxinyongkakh = fsshenqingrenqitaxinyongkakh;
	}
	public String getFsshenqingrenqitaxinyongkalx() {
		return fsshenqingrenqitaxinyongkalx;
	}
	public void setFsshenqingrenqitaxinyongkalx(String fsshenqingrenqitaxinyongkalx) {
		this.fsshenqingrenqitaxinyongkalx = fsshenqingrenqitaxinyongkalx;
	}
	public String getFsshenqingrenqitaxinyongkxyed() {
		return fsshenqingrenqitaxinyongkxyed;
	}
	public void setFsshenqingrenqitaxinyongkxyed(
			String fsshenqingrenqitaxinyongkxyed) {
		this.fsshenqingrenqitaxinyongkxyed = fsshenqingrenqitaxinyongkxyed;
	}
	public String getFsshenqingrentuzixingming() {
		return fsshenqingrentuzixingming;
	}
	public void setFsshenqingrentuzixingming(String fsshenqingrentuzixingming) {
		this.fsshenqingrentuzixingming = fsshenqingrentuzixingming;
	}
	public String getFsxiaofeishifouxuyaomima() {
		return fsxiaofeishifouxuyaomima;
	}
	public void setFsxiaofeishifouxuyaomima(String fsxiaofeishifouxuyaomima) {
		this.fsxiaofeishifouxuyaomima = fsxiaofeishifouxuyaomima;
	}
	public String getFskapianbanmiandaima() {
		return fskapianbanmiandaima;
	}
	public void setFskapianbanmiandaima(String fskapianbanmiandaima) {
		this.fskapianbanmiandaima = fskapianbanmiandaima;
	}
	public String getFsgongsimingchengtuzi() {
		return fsgongsimingchengtuzi;
	}
	public void setFsgongsimingchengtuzi(String fsgongsimingchengtuzi) {
		this.fsgongsimingchengtuzi = fsgongsimingchengtuzi;
	}
	public String getFsshifoudayinmixin() {
		return fsshifoudayinmixin;
	}
	public void setFsshifoudayinmixin(String fsshifoudayinmixin) {
		this.fsshifoudayinmixin = fsshifoudayinmixin;
	}
	public String getFsgexingbiaoshima() {
		return fsgexingbiaoshima;
	}
	public void setFsgexingbiaoshima(String fsgexingbiaoshima) {
		this.fsgexingbiaoshima = fsgexingbiaoshima;
	}
	public String getFsfukayuzhukashenqingrengx() {
		return fsfukayuzhukashenqingrengx;
	}
	public void setFsfukayuzhukashenqingrengx(String fsfukayuzhukashenqingrengx) {
		this.fsfukayuzhukashenqingrengx = fsfukayuzhukashenqingrengx;
	}
	public String getFsbaoliuziduan() {
		return fsbaoliuziduan;
	}
	public void setFsbaoliuziduan(String fsbaoliuziduan) {
		this.fsbaoliuziduan = fsbaoliuziduan;
	}
	public String getFsshenqingrenjiatingdianhuafj() {
		return fsshenqingrenjiatingdianhuafj;
	}
	public void setFsshenqingrenjiatingdianhuafj(
			String fsshenqingrenjiatingdianhuafj) {
		this.fsshenqingrenjiatingdianhuafj = fsshenqingrenjiatingdianhuafj;
	}
	public String getFszhengjianyouxiaoqi() {
		return fszhengjianyouxiaoqi;
	}
	public void setFszhengjianyouxiaoqi(String fszhengjianyouxiaoqi) {
		this.fszhengjianyouxiaoqi = fszhengjianyouxiaoqi;
	}

}
