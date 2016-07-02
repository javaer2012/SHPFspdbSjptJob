package com.ideal.spdb.utils;

import com.ideal.spdb.bairong.to.BairongRecord;

public class BairongUtil {

	public static String parseBairong(BairongRecord record) {
		StringBuilder sb = new StringBuilder();
		/************************************/
		// specialList_c  id
		if(record.getSpecialList_c() != null && record.getSpecialList_c().getId() != null){
			sb.append(record.getSpecialList_c().getId().getBank_bad() + "|");
			sb.append(record.getSpecialList_c().getId().getBank_overdue() + "|");
			sb.append(record.getSpecialList_c().getId().getBank_fraud() + "|");
			sb.append(record.getSpecialList_c().getId().getBank_lost() + "|");
			sb.append(record.getSpecialList_c().getId().getBank_refuse() + "|");
			sb.append(record.getSpecialList_c().getId().getCredit_bad() + "|");
			sb.append(record.getSpecialList_c().getId().getP2p_bad() + "|");
			sb.append(record.getSpecialList_c().getId().getP2p_overdue() + "|");
			sb.append(record.getSpecialList_c().getId().getP2p_fraud() + "|");
			sb.append(record.getSpecialList_c().getId().getP2p_lost() + "|");
			sb.append(record.getSpecialList_c().getId().getP2p_refuse() + "|");
			sb.append(record.getSpecialList_c().getId().getPhone_overdue() + "|");
			sb.append(record.getSpecialList_c().getId().getInsurance_fraud() + "|");
			sb.append(record.getSpecialList_c().getId().getCourt_bad() + "|");
			sb.append(record.getSpecialList_c().getId().getCourt_executed() + "|");
		}else {
			sb.append("|||||||||||||||");
		}
		// specialList_c  cell
		if(record.getSpecialList_c() != null && record.getSpecialList_c().getCell() != null){
			sb.append(record.getSpecialList_c().getCell().getBank_bad() + "|");
			sb.append(record.getSpecialList_c().getCell().getBank_overdue() + "|");
			sb.append(record.getSpecialList_c().getCell().getBank_fraud() + "|");
			sb.append(record.getSpecialList_c().getCell().getBank_lost() + "|");
			sb.append(record.getSpecialList_c().getCell().getBank_refuse() + "|");
			sb.append(record.getSpecialList_c().getCell().getP2p_overdue() + "|");
			sb.append(record.getSpecialList_c().getCell().getP2p_fraud() + "|");
			sb.append(record.getSpecialList_c().getCell().getInsurance_fraud() + "|");
			sb.append(record.getSpecialList_c().getCell().getP2p_bad() + "|");
			sb.append(record.getSpecialList_c().getCell().getP2p_lost() + "|");
			sb.append(record.getSpecialList_c().getCell().getP2p_refuse() + "|");
		}else {
			sb.append("|||||||||||");
		}
		
		// specialList_c  Gid
		if(record.getSpecialList_c() != null && record.getSpecialList_c().getGid() != null){
			sb.append(record.getSpecialList_c().getGid().getBank_bad() + "|");
			sb.append(record.getSpecialList_c().getGid().getBank_overdue() + "|");
			sb.append(record.getSpecialList_c().getGid().getBank_fraud() + "|");
			sb.append(record.getSpecialList_c().getGid().getBank_lost() + "|");
			sb.append(record.getSpecialList_c().getGid().getBank_refuse() + "|");
			sb.append(record.getSpecialList_c().getGid().getP2p_overdue() + "|");
			sb.append(record.getSpecialList_c().getGid().getP2p_fraud() + "|");
			sb.append(record.getSpecialList_c().getGid().getInsurance_fraud() + "|");
			sb.append(record.getSpecialList_c().getGid().getP2p_bad() + "|");
			sb.append(record.getSpecialList_c().getGid().getP2p_lost() + "|");
			sb.append(record.getSpecialList_c().getGid().getP2p_refuse() + "|");
		}else {
			sb.append("|||||||||||");
		}
		
		/************************************/
		//applyLoan  month3  id  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth3() != null 
				&& record.getApplyLoan().getMonth3().getId() != null && record.getApplyLoan().getMonth3().getId().getBank() != null){
			sb.append(record.getApplyLoan().getMonth3().getId().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getId().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getId().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month3  id  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth3() != null 
				&& record.getApplyLoan().getMonth3().getId() != null && record.getApplyLoan().getMonth3().getId().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth3().getId().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getId().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getId().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month6  id  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth6() != null 
				&& record.getApplyLoan().getMonth6().getId() != null && record.getApplyLoan().getMonth6().getId().getBank() != null){
			sb.append(record.getApplyLoan().getMonth6().getId().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getId().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getId().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month6  id  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth6() != null 
				&& record.getApplyLoan().getMonth6().getId() != null && record.getApplyLoan().getMonth6().getId().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth6().getId().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getId().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getId().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month12  id  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth12() != null 
				&& record.getApplyLoan().getMonth12().getId() != null && record.getApplyLoan().getMonth12().getId().getBank() != null){
			sb.append(record.getApplyLoan().getMonth12().getId().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getId().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getId().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month12  id  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth12() != null 
				&& record.getApplyLoan().getMonth12().getId() != null && record.getApplyLoan().getMonth12().getId().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth12().getId().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getId().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getId().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		
		
		//applyLoan  month3  Cell  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth3() != null 
				&& record.getApplyLoan().getMonth3().getCell() != null && record.getApplyLoan().getMonth3().getCell().getBank() != null){
			sb.append(record.getApplyLoan().getMonth3().getCell().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getCell().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getCell().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month3  Cell  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth3() != null 
				&& record.getApplyLoan().getMonth3().getCell() != null && record.getApplyLoan().getMonth3().getCell().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth3().getCell().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getCell().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getCell().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month6  Cell  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth6() != null 
				&& record.getApplyLoan().getMonth6().getCell() != null && record.getApplyLoan().getMonth6().getCell().getBank() != null){
			sb.append(record.getApplyLoan().getMonth6().getCell().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getCell().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getCell().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month6  Cell  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth6() != null 
				&& record.getApplyLoan().getMonth6().getCell() != null && record.getApplyLoan().getMonth6().getCell().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth6().getCell().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getCell().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getCell().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month12  Cell  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth12() != null 
				&& record.getApplyLoan().getMonth12().getCell() != null && record.getApplyLoan().getMonth12().getCell().getBank() != null){
			sb.append(record.getApplyLoan().getMonth12().getCell().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getCell().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getCell().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month12  Cell  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth12() != null 
				&& record.getApplyLoan().getMonth12().getCell() != null && record.getApplyLoan().getMonth12().getCell().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth12().getCell().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getCell().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getCell().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		
		//applyLoan  month3  Gid  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth3() != null 
				&& record.getApplyLoan().getMonth3().getGid() != null && record.getApplyLoan().getMonth3().getGid().getBank() != null){
			sb.append(record.getApplyLoan().getMonth3().getGid().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getGid().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getGid().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month3  Gid  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth3() != null 
				&& record.getApplyLoan().getMonth3().getGid() != null && record.getApplyLoan().getMonth3().getGid().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth3().getGid().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getGid().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth3().getGid().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month6  Gid  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth6() != null 
				&& record.getApplyLoan().getMonth6().getGid() != null && record.getApplyLoan().getMonth6().getGid().getBank() != null){
			sb.append(record.getApplyLoan().getMonth6().getGid().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getGid().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getGid().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month6  Gid  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth6() != null 
				&& record.getApplyLoan().getMonth6().getGid() != null && record.getApplyLoan().getMonth6().getGid().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth6().getGid().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getGid().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth6().getGid().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month12  Gid  bank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth12() != null 
				&& record.getApplyLoan().getMonth12().getGid() != null && record.getApplyLoan().getMonth12().getGid().getBank() != null){
			sb.append(record.getApplyLoan().getMonth12().getGid().getBank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getGid().getBank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getGid().getBank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		//applyLoan  month12  Gid  notbank
		if(record.getApplyLoan() != null && record.getApplyLoan().getMonth12() != null 
				&& record.getApplyLoan().getMonth12().getGid() != null && record.getApplyLoan().getMonth12().getGid().getNotbank() != null){
			sb.append(record.getApplyLoan().getMonth12().getGid().getNotbank().getSelfnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getGid().getNotbank().getAllnumber() + "|");
			sb.append(record.getApplyLoan().getMonth12().getGid().getNotbank().getOrgnumber() + "|");
		}else {
			sb.append("|||");
		}
		
		/************************************/
		if(record.getLocation() != null){
			//location  home_addr
			if(record.getLocation().getHome_addr() != null){
				sb.append( record.getLocation().getHome_addr().getAddr11() + "|");
				sb.append( record.getLocation().getHome_addr().getAddr12() + "|");
			}else {
				sb.append("||");
			}
			//location  biz_addr
			if(record.getLocation().getBiz_addr() != null){
				sb.append( record.getLocation().getBiz_addr().getAddr21() + "|");
				sb.append( record.getLocation().getBiz_addr().getAddr22() + "|");
			}else {
				sb.append("||");
			}
			//location  per_addr
			if(record.getLocation().getPer_addr() != null){
				sb.append( record.getLocation().getPer_addr().getAddr31() + "|");
				sb.append( record.getLocation().getPer_addr().getAddr32() + "|");
			}else {
				sb.append("||");
			}
			//location  apply_addr
			if(record.getLocation().getApply_addr() != null){
				sb.append( record.getLocation().getApply_addr().getAddr41() + "|");
				sb.append( record.getLocation().getApply_addr().getAddr42() + "|");
			}else {
				sb.append("||");
			}
			//location  oth_addr
			if(record.getLocation().getOth_addr() != null){
				sb.append( record.getLocation().getOth_addr().getAddr51() + "|");
				sb.append( record.getLocation().getOth_addr().getAddr52() + "|");
			}else {
				sb.append("||");
			}
		}else {
			sb.append("||||||||");
		}
		
		/************************************/
		if(record.getStability_c() != null){
			//stability_c  authentication 
			if(record.getStability_c().getAuthentication() != null){
				sb.append( record.getStability_c().getAuthentication().getId() + "|");
				sb.append( record.getStability_c().getAuthentication().getCell() + "|");
				sb.append( record.getStability_c().getAuthentication().getMail() + "|");
				sb.append( record.getStability_c().getAuthentication().getKey_relation() + "|");
				sb.append( record.getStability_c().getAuthentication().getName() + "|");
				sb.append( record.getStability_c().getAuthentication().getBiz_tel() + "|");
				sb.append( record.getStability_c().getAuthentication().getHome_tel() + "|");
				sb.append( record.getStability_c().getAuthentication().getId_name() + "|");
			}else {
				sb.append("||||||||");
			}
			//stability_c  id 
			if(record.getStability_c().getId() != null && record.getStability_c().getId().getNumber() != null){
				sb.append( record.getStability_c().getId().getNumber() + "|");
			}else {
				sb.append("|");
			}
			//stability_c  cell 
			if(record.getStability_c().getCell() != null && record.getStability_c().getCell().getNumber() != null && record.getStability_c().getCell().getFirsttime() != null){
				sb.append( record.getStability_c().getCell().getNumber() + "|");
				sb.append( record.getStability_c().getCell().getFirsttime() + "|");
			}else {
				sb.append("||");
			}
			//stability_c  mail 
			if(record.getStability_c().getMail() != null && record.getStability_c().getMail().getNumber() != null){
				sb.append( record.getStability_c().getMail().getNumber() + "|");
			}else {
				sb.append("|");
			}
			//stability_c  name 
			if(record.getStability_c().getName() != null && record.getStability_c().getName().getNumber() != null){
				sb.append( record.getStability_c().getName().getNumber() + "|");
			}else {
				sb.append("|");
			}
			//stability_c  tel 
			if(record.getStability_c().getTel() != null && record.getStability_c().getTel().getNumber() != null){
				sb.append( record.getStability_c().getTel().getNumber() + "|");
			}else {
				sb.append("|");
			}
			//stability_c  addr 
			if(record.getStability_c().getAddr() != null && record.getStability_c().getAddr().getNumber() != null){
				sb.append( record.getStability_c().getAddr().getNumber() + "|");
			}else {
				sb.append("|");
			}
		}else {
			sb.append("|||||||||||||||");
		}
		
		/************************************/
		if(record.getMedia_c() != null){
			if(record.getMedia_c().getMax() != null){
				//media_c max month3
				if(record.getMedia_c().getMax().getMonth3() != null){
					sb.append( record.getMedia_c().getMax().getMonth3().getVisitdays() + "|");
					sb.append( record.getMedia_c().getMax().getMonth3().getCate() + "|");
					sb.append( record.getMedia_c().getMax().getMonth3().getDays_prop() + "|");
				}else {
					sb.append("|||");
				}
				//media_c max month12
				if(record.getMedia_c().getMax().getMonth12() != null){
					sb.append( record.getMedia_c().getMax().getMonth12().getVisitdays() + "|");
					sb.append( record.getMedia_c().getMax().getMonth12().getCate() + "|");
					sb.append( record.getMedia_c().getMax().getMonth12().getDays_prop() + "|");
				}else {
					sb.append("|||");
				}
			}else {
				sb.append("||||||");
			}
			
			if(record.getMedia_c().getTotal() != null){
				//media_c total month3
				if(record.getMedia_c().getTotal().getMonth3() != null){
					sb.append( record.getMedia_c().getTotal().getMonth3().getVisitdays() + "|");
					sb.append( record.getMedia_c().getTotal().getMonth3().getCatenum() + "|");
				}else {
					sb.append("||");
				}
				//media_c total month12
				if(record.getMedia_c().getTotal().getMonth12() != null){
					sb.append( record.getMedia_c().getTotal().getMonth12().getVisitdays() + "|");
					sb.append( record.getMedia_c().getTotal().getMonth12().getCatenum() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("||||");
			}
			
		}else {
			sb.append("||||||||||");
		}
		
		/************************************/
		if(record.getConsumption_c() != null){
			//consumption_c
			sb.append( record.getConsumption_c().getContinue_() + "|");
			sb.append( record.getConsumption_c().getTime_recent() + "|");
			//consumption_c max month3.
			if(record.getConsumption_c().getMax() != null && record.getConsumption_c().getMax().getMonth3() != null){
				sb.append( record.getConsumption_c().getMax().getMonth3().getNumber() + "|");
				sb.append( record.getConsumption_c().getMax().getMonth3().getPay() + "|");
				sb.append( record.getConsumption_c().getMax().getMonth3().getPaycate() + "|");
			}else {
				sb.append("|||");
			}
			//consumption_c max month12
			if(record.getConsumption_c().getMax() != null && record.getConsumption_c().getMax().getMonth12() != null){
				sb.append( record.getConsumption_c().getMax().getMonth12().getNumber() + "|");
				sb.append( record.getConsumption_c().getMax().getMonth12().getPay() + "|");
				sb.append( record.getConsumption_c().getMax().getMonth12().getPaycate() + "|");
			}else {
				sb.append("|||");
			}
			//consumption_c total month3
			if(record.getConsumption_c().getTotal() != null && record.getConsumption_c().getTotal().getMonth3() != null){
				sb.append( record.getConsumption_c().getTotal().getMonth3().getVisits() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth3().getNumber() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth3().getPay() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth3().getP_catenum() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth3().getV_catenum() + "|");
			}else {
				sb.append("|||||");
			}
			
			//consumption_c total month12
			if(record.getConsumption_c().getTotal() != null && record.getConsumption_c().getTotal().getMonth12() != null){
				sb.append( record.getConsumption_c().getTotal().getMonth12().getVisits() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth12().getNumber() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth12().getPay() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth12().getP_catenum() + "|");
				sb.append( record.getConsumption_c().getTotal().getMonth12().getV_catenum() + "|");
			}else {
				sb.append("|||||");
			}
		}else {
			sb.append("||||||||||||||||||");
		}
		/************************************/
		if(record.getAccountchange() != null){
			//accountchange 
			sb.append( record.getAccountchange().getCardindex() + "|");
			sb.append( record.getAccountchange().getRegionno() + "|");
			//accountchange m1m3
			if(record.getAccountchange().getM1m3() != null){
				sb.append( record.getAccountchange().getM1m3().getLoan() + "|");
				//accountchange m1m3 creditcard
				if(record.getAccountchange().getM1m3().getCreditcard() != null){
					sb.append( record.getAccountchange().getM1m3().getCreditcard().getCash() + "|");
					sb.append( record.getAccountchange().getM1m3().getCreditcard().getDefault_() + "|");
					sb.append( record.getAccountchange().getM1m3().getCreditcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM1m3().getCreditcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM1m3().getCreditcard().getStatus() + "|");
				}
				//accountchange m1m3 debitcard
				if(record.getAccountchange().getM1m3().getDebitcard() != null){
					sb.append( record.getAccountchange().getM1m3().getDebitcard().getBalance() + "|");
					sb.append( record.getAccountchange().getM1m3().getDebitcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM1m3().getDebitcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM1m3().getDebitcard().getInvestment() + "|");
					sb.append( record.getAccountchange().getM1m3().getDebitcard().getRepay() + "|");
				}
			}else {
				sb.append("|||||||||||");
			}
			//accountchange m4m6
			if(record.getAccountchange().getM4m6() != null){
				sb.append( record.getAccountchange().getM4m6().getLoan() + "|");
				if(record.getAccountchange().getM4m6().getCreditcard() != null){
					//accountchange m4m6 creditcard
					sb.append( record.getAccountchange().getM4m6().getCreditcard().getCash() + "|");
					sb.append( record.getAccountchange().getM4m6().getCreditcard().getDefault_() + "|");
					sb.append( record.getAccountchange().getM4m6().getCreditcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM4m6().getCreditcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM4m6().getCreditcard().getStatus() + "|");
				}
				if(record.getAccountchange().getM4m6().getDebitcard() != null){
					//accountchange m4m6 debitcard
					sb.append( record.getAccountchange().getM4m6().getDebitcard().getBalance() + "|");
					sb.append( record.getAccountchange().getM4m6().getDebitcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM4m6().getDebitcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM4m6().getDebitcard().getInvestment() + "|");
					sb.append( record.getAccountchange().getM4m6().getDebitcard().getRepay() + "|");
				}
			}else {
				sb.append("|||||||||||");
			}
			//accountchange m7m9
			if(record.getAccountchange().getM7m9() != null){
				sb.append( record.getAccountchange().getM7m9().getLoan() + "|");
				if(record.getAccountchange().getM7m9().getCreditcard() != null){
					//accountchange m7m9 creditcard
					sb.append( record.getAccountchange().getM7m9().getCreditcard().getCash() + "|");
					sb.append( record.getAccountchange().getM7m9().getCreditcard().getDefault_() + "|");
					sb.append( record.getAccountchange().getM7m9().getCreditcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM7m9().getCreditcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM7m9().getCreditcard().getStatus() + "|");
				}
				if(record.getAccountchange().getM7m9().getDebitcard() != null){
					//accountchange m7m9 debitcard
					sb.append( record.getAccountchange().getM7m9().getDebitcard().getBalance() + "|");
					sb.append( record.getAccountchange().getM7m9().getDebitcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM7m9().getDebitcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM7m9().getDebitcard().getInvestment() + "|");
					sb.append( record.getAccountchange().getM7m9().getDebitcard().getRepay() + "|");
				}
			}else {
				sb.append("|||||||||||");
			}
			//accountchange m10m12
			if(record.getAccountchange().getM10m12() != null){
				sb.append( record.getAccountchange().getM10m12().getLoan() + "|");
				if(record.getAccountchange().getM10m12().getCreditcard() != null){
					//accountchange m10m12 creditcard
					sb.append( record.getAccountchange().getM10m12().getCreditcard().getCash() + "|");
					sb.append( record.getAccountchange().getM10m12().getCreditcard().getDefault_() + "|");
					sb.append( record.getAccountchange().getM10m12().getCreditcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM10m12().getCreditcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM10m12().getCreditcard().getStatus() + "|");
				}
				if(record.getAccountchange().getM10m12().getDebitcard() != null){
					//accountchange m10m12 debitcard
					sb.append( record.getAccountchange().getM10m12().getDebitcard().getBalance() + "|");
					sb.append( record.getAccountchange().getM10m12().getDebitcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM10m12().getDebitcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM10m12().getDebitcard().getInvestment() + "|");
					sb.append( record.getAccountchange().getM10m12().getDebitcard().getRepay() + "|");
				}
			}else {
				sb.append("|||||||||||");
			}
			//accountchange m13m15
			if(record.getAccountchange().getM13m15() != null){
				sb.append( record.getAccountchange().getM13m15().getLoan() + "|");
				if(record.getAccountchange().getM13m15().getCreditcard() != null){
					//accountchange m13m15 creditcard
					sb.append( record.getAccountchange().getM13m15().getCreditcard().getCash() + "|");
					sb.append( record.getAccountchange().getM13m15().getCreditcard().getDefault_() + "|");
					sb.append( record.getAccountchange().getM13m15().getCreditcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM13m15().getCreditcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM13m15().getCreditcard().getStatus() + "|");
				}
				if(record.getAccountchange().getM13m15().getDebitcard() != null){
					//accountchange m13m15 debitcard
					sb.append( record.getAccountchange().getM13m15().getDebitcard().getBalance() + "|");
					sb.append( record.getAccountchange().getM13m15().getDebitcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM13m15().getDebitcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM13m15().getDebitcard().getInvestment() + "|");
					sb.append( record.getAccountchange().getM13m15().getDebitcard().getRepay() + "|");
				}
			}else {
				sb.append("|||||||||||");
			}
			//accountchange m16m18
			if(record.getAccountchange().getM16m18() != null){
				sb.append( record.getAccountchange().getM16m18().getLoan() + "|");
				if(record.getAccountchange().getM16m18().getCreditcard() != null){
					//accountchange m16m18 creditcard
					sb.append( record.getAccountchange().getM16m18().getCreditcard().getCash() + "|");
					sb.append( record.getAccountchange().getM16m18().getCreditcard().getDefault_() + "|");
					sb.append( record.getAccountchange().getM16m18().getCreditcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM16m18().getCreditcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM16m18().getCreditcard().getStatus() + "|");
				}
				if(record.getAccountchange().getM16m18().getDebitcard() != null){
					//accountchange m16m18 debitcard
					sb.append( record.getAccountchange().getM16m18().getDebitcard().getBalance() + "|");
					sb.append( record.getAccountchange().getM16m18().getDebitcard().getIncome() + "|");
					sb.append( record.getAccountchange().getM16m18().getDebitcard().getOutgo() + "|");
					sb.append( record.getAccountchange().getM16m18().getDebitcard().getInvestment() + "|");
					sb.append( record.getAccountchange().getM16m18().getDebitcard().getRepay() + "|");
				}
			}else {
				sb.append("|||||||||||");
			}
			
		}else {
			sb.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		}
		
		/************************************/
		if(record.getPayConsumption() != null){
			//payConsumption thm1
			if(record.getPayConsumption().getThm1() != null){
				sb.append( record.getPayConsumption().getThm1().getPay() + "|");
				sb.append( record.getPayConsumption().getThm1().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm1().getMaxNumberProvince() + "|");
				//payConsumption thm1 first
				if(record.getPayConsumption().getThm1().getFirst() != null){
					sb.append( record.getPayConsumption().getThm1().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm1().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm1 second
				if(record.getPayConsumption().getThm1().getSecond() != null){
					sb.append( record.getPayConsumption().getThm1().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm1().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm1 third
				if(record.getPayConsumption().getThm1().getThird() != null){
					sb.append( record.getPayConsumption().getThm1().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm1().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm1 night
				if(record.getPayConsumption().getThm1().getNight() != null){
					sb.append( record.getPayConsumption().getThm1().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm1().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm2
			if(record.getPayConsumption().getThm2() != null){
				sb.append( record.getPayConsumption().getThm2().getPay() + "|");
				sb.append( record.getPayConsumption().getThm2().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm2().getMaxNumberProvince() + "|");
				//payConsumption thm2 first
				if(record.getPayConsumption().getThm2().getFirst() != null){
					sb.append( record.getPayConsumption().getThm2().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm2().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm2 second
				if(record.getPayConsumption().getThm2().getSecond() != null){
					sb.append( record.getPayConsumption().getThm2().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm2().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm2 third
				if(record.getPayConsumption().getThm2().getThird() != null){
					sb.append( record.getPayConsumption().getThm2().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm2().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm2 night
				if(record.getPayConsumption().getThm2().getNight() != null){
					sb.append( record.getPayConsumption().getThm2().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm2().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm3
			if(record.getPayConsumption().getThm3() != null){
				sb.append( record.getPayConsumption().getThm3().getPay() + "|");
				sb.append( record.getPayConsumption().getThm3().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm3().getMaxNumberProvince() + "|");
				//payConsumption thm3 first
				if(record.getPayConsumption().getThm3().getFirst() != null){
					sb.append( record.getPayConsumption().getThm3().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm3().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm3 second
				if(record.getPayConsumption().getThm3().getSecond() != null){
					sb.append( record.getPayConsumption().getThm3().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm3().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm3 third
				if(record.getPayConsumption().getThm3().getThird() != null){
					sb.append( record.getPayConsumption().getThm3().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm3().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm3 night
				if(record.getPayConsumption().getThm3().getNight() != null){
					sb.append( record.getPayConsumption().getThm3().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm3().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm4
			if(record.getPayConsumption().getThm4() != null){
				sb.append( record.getPayConsumption().getThm4().getPay() + "|");
				sb.append( record.getPayConsumption().getThm4().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm4().getMaxNumberProvince() + "|");
				//payConsumption thm4 first
				if(record.getPayConsumption().getThm4().getFirst() != null){
					sb.append( record.getPayConsumption().getThm4().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm4().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm4 second
				if(record.getPayConsumption().getThm4().getSecond() != null){
					sb.append( record.getPayConsumption().getThm4().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm4().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm4 third
				if(record.getPayConsumption().getThm4().getThird() != null){
					sb.append( record.getPayConsumption().getThm4().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm4().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm4 night
				if(record.getPayConsumption().getThm4().getNight() != null){
					sb.append( record.getPayConsumption().getThm4().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm4().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm5
			if(record.getPayConsumption().getThm5() != null){
				sb.append( record.getPayConsumption().getThm5().getPay() + "|");
				sb.append( record.getPayConsumption().getThm5().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm5().getMaxNumberProvince() + "|");
				//payConsumption thm5 first
				if(record.getPayConsumption().getThm5().getFirst() != null){
					sb.append( record.getPayConsumption().getThm5().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm5().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm5 second
				if(record.getPayConsumption().getThm5().getSecond() != null){
					sb.append( record.getPayConsumption().getThm5().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm5().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm5 third
				if(record.getPayConsumption().getThm5().getThird() != null){
					sb.append( record.getPayConsumption().getThm5().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm5().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm5 night
				if(record.getPayConsumption().getThm5().getNight() != null){
					sb.append( record.getPayConsumption().getThm5().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm5().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm6
			if(record.getPayConsumption().getThm6() != null){
				sb.append( record.getPayConsumption().getThm6().getPay() + "|");
				sb.append( record.getPayConsumption().getThm6().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm6().getMaxNumberProvince() + "|");
				//payConsumption thm6 first
				if(record.getPayConsumption().getThm6().getFirst() != null){
					sb.append( record.getPayConsumption().getThm6().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm6().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm6 second
				if(record.getPayConsumption().getThm6().getSecond() != null){
					sb.append( record.getPayConsumption().getThm6().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm6().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm6 third
				if(record.getPayConsumption().getThm6().getThird() != null){
					sb.append( record.getPayConsumption().getThm6().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm6().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm6 night
				if(record.getPayConsumption().getThm6().getNight() != null){
					sb.append( record.getPayConsumption().getThm6().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm6().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm7
			if(record.getPayConsumption().getThm7() != null){
				sb.append( record.getPayConsumption().getThm7().getPay() + "|");
				sb.append( record.getPayConsumption().getThm7().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm7().getMaxNumberProvince() + "|");
				//payConsumption thm7 first
				if(record.getPayConsumption().getThm7().getFirst() != null){
					sb.append( record.getPayConsumption().getThm7().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm7().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm7 second
				if(record.getPayConsumption().getThm7().getSecond() != null){
					sb.append( record.getPayConsumption().getThm7().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm7().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm7 third
				if(record.getPayConsumption().getThm7().getThird() != null){
					sb.append( record.getPayConsumption().getThm7().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm7().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm7 night
				if(record.getPayConsumption().getThm7().getNight() != null){
					sb.append( record.getPayConsumption().getThm7().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm7().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm8
			if(record.getPayConsumption().getThm8() != null){
				sb.append( record.getPayConsumption().getThm8().getPay() + "|");
				sb.append( record.getPayConsumption().getThm8().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm8().getMaxNumberProvince() + "|");
				//payConsumption thm8 first
				if(record.getPayConsumption().getThm8().getFirst() != null){
					sb.append( record.getPayConsumption().getThm8().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm8().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm8 second
				if(record.getPayConsumption().getThm8().getSecond() != null){
					sb.append( record.getPayConsumption().getThm8().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm8().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm8 third
				if(record.getPayConsumption().getThm8().getThird() != null){
					sb.append( record.getPayConsumption().getThm8().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm8().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm8 night
				if(record.getPayConsumption().getThm8().getNight() != null){
					sb.append( record.getPayConsumption().getThm8().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm8().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm9
			if(record.getPayConsumption().getThm9() != null){
				sb.append( record.getPayConsumption().getThm9().getPay() + "|");
				sb.append( record.getPayConsumption().getThm9().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm9().getMaxNumberProvince() + "|");
				//payConsumption thm9 first
				if(record.getPayConsumption().getThm9().getFirst() != null){
					sb.append( record.getPayConsumption().getThm9().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm9().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm9 second
				if(record.getPayConsumption().getThm9().getSecond() != null){
					sb.append( record.getPayConsumption().getThm9().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm9().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm9 third
				if(record.getPayConsumption().getThm9().getThird() != null){
					sb.append( record.getPayConsumption().getThm9().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm9().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm9 night
				if(record.getPayConsumption().getThm9().getNight() != null){
					sb.append( record.getPayConsumption().getThm9().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm9().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm10
			if(record.getPayConsumption().getThm10() != null){
				sb.append( record.getPayConsumption().getThm10().getPay() + "|");
				sb.append( record.getPayConsumption().getThm10().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm10().getMaxNumberProvince() + "|");
				//payConsumption thm10 first
				if(record.getPayConsumption().getThm10().getFirst() != null){
					sb.append( record.getPayConsumption().getThm10().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm10().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm10 second
				if(record.getPayConsumption().getThm10().getSecond() != null){
					sb.append( record.getPayConsumption().getThm10().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm10().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm10 third
				if(record.getPayConsumption().getThm10().getThird() != null){
					sb.append( record.getPayConsumption().getThm10().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm10().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm10 night
				if(record.getPayConsumption().getThm10().getNight() != null){
					sb.append( record.getPayConsumption().getThm10().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm10().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm11
			if(record.getPayConsumption().getThm11() != null){
				sb.append( record.getPayConsumption().getThm11().getPay() + "|");
				sb.append( record.getPayConsumption().getThm11().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm11().getMaxNumberProvince() + "|");
				//payConsumption thm11 first
				if(record.getPayConsumption().getThm11().getFirst() != null){
					sb.append( record.getPayConsumption().getThm11().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm11().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm11 second
				if(record.getPayConsumption().getThm11().getSecond() != null){
					sb.append( record.getPayConsumption().getThm11().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm11().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm11 third
				if(record.getPayConsumption().getThm11().getThird() != null){
					sb.append( record.getPayConsumption().getThm11().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm11().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm11 night
				if(record.getPayConsumption().getThm11().getNight() != null){
					sb.append( record.getPayConsumption().getThm11().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm11().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
			//payConsumption thm12
			if(record.getPayConsumption().getThm12() != null){
				sb.append( record.getPayConsumption().getThm12().getPay() + "|");
				sb.append( record.getPayConsumption().getThm12().getNumber() + "|");
				sb.append( record.getPayConsumption().getThm12().getMaxNumberProvince() + "|");
				//payConsumption thm12 first
				if(record.getPayConsumption().getThm12().getFirst() != null){
					sb.append( record.getPayConsumption().getThm12().getFirst().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm12().getFirst().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm12 second
				if(record.getPayConsumption().getThm12().getSecond() != null){
					sb.append( record.getPayConsumption().getThm12().getSecond().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm12().getSecond().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm12 third
				if(record.getPayConsumption().getThm12().getThird() != null){
					sb.append( record.getPayConsumption().getThm12().getThird().getPayMcc() + "|");
					sb.append( record.getPayConsumption().getThm12().getThird().getNumberMcc() + "|");
				}else {
					sb.append("||");
				}
				//payConsumption thm12 night
				if(record.getPayConsumption().getThm12().getNight() != null){
					sb.append( record.getPayConsumption().getThm12().getNight().getPay() + "|");
					sb.append( record.getPayConsumption().getThm12().getNight().getNumber() + "|");
				}else {
					sb.append("||");
				}
			}else {
				sb.append("|||||||||||");
			}
		}else {
			sb.append("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		}
		
		/************************************/
		//score
		if(record.getScore() != null){
			sb.append(record.getScore().getBankpfpoint() + "|");
		}else {
			sb.append("|");
		}
		/************************************/
		//authentication
		if(record.getAuthentication() != null){
			sb.append( record.getAuthentication().getId() + "|");
			sb.append( record.getAuthentication().getCell() + "|");
			sb.append( record.getAuthentication().getMail() + "|");
			sb.append( record.getAuthentication().getKey_relation() + "|");
			sb.append( record.getAuthentication().getName() + "|");
			sb.append( record.getAuthentication().getBiz_tel() + "|");
			sb.append( record.getAuthentication().getHome_tel() + "|");
			sb.append( record.getAuthentication().getId_name());
		}else {
			sb.append("|||||||");
		}
		String result = sb.toString();
		result = result.replaceAll("null", "");
		return result;
	}
	
	public static void main(String[] args) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {
//		String str = "{\"code\":\"00\",\"swift_number\":\"100179_20151217154154_4295\",\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"tel_biz\":\"0\",\"tel_home\":\"0\"},\"Location\":{\"home_addr\":{\"addr11\":\"15.8\"},\"biz_addr\":{\"addr21\":\"13.3\"},\"per_addr\":{},\"apply_addr\":{},\"oth_addr\":{}},\"Stability_c\":{\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"id-name\":\"0\",\"biz_tel\":\"0\",\"home_tel\":\"0\"},\"id\":{\"number\":\"0\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"2009\"},\"mail\":{\"number\":\"1\"},\"name\":{\"number\":\"1\"},\"tel\":{\"number\":\"0\"},\"addr\":{\"number\":\"1\"}},\"Stability\":{\"id\":{\"number\":\"0\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"2009\"},\"mail\":{\"number\":\"1\"},\"name\":{\"number\":\"1\"},\"tel\":{\"number\":\"0\"},\"addr\":{\"number\":\"1\"}},\"Consumption_c\":{\"continue\":\"M1\",\"time_recent\":\"T1\",\"total\":{\"month3\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"p_catenum\":\"1\",\"v_catenum\":\"1\"},\"month12\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"p_catenum\":\"1\",\"v_catenum\":\"1\"}},\"max\":{\"month3\":{\"number\":\"1\",\"pay\":\"10\",\"paycate\":\"C22\"},\"month12\":{\"number\":\"1\",\"pay\":\"10\",\"paycate\":\"C22\"}},\"month3\":{},\"month12\":{}},\"Consumption\":{\"month3\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\"}},\"month6\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\"}},\"month12\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"maxpay\":\"10\"}},\"level\":{\"文化娱乐\":\"0.0724\"}},\"ApplyLoan\":{},\"SpecialList_c\":{},\"Score\":{\"bankpfpoint\":\"667\"},\"Accountchange\":{\"cardindex\":\"4\",\"regionno\":\"0021\",\"m1m3\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"03\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"20\",\"outgo\":\"20\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m4m6\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"01\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"38\",\"outgo\":\"38\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m7m9\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"24\",\"outgo\":\"23\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m10m12\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"25\",\"outgo\":\"25\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m13m15\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"12\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"22\",\"outgo\":\"21\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m16m18\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"23\",\"outgo\":\"24\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"}},\"Assets\":{\"house\":\"0\",\"car\":\"0\",\"fin\":\"0\",\"wealth\":\"0\"},\"Media_c\":{\"total\":{\"month3\":{\"visitdays\":\"2\",\"catenum\":\"1\"},\"month12\":{\"visitdays\":\"2\",\"catenum\":\"1\"}},\"max\":{\"month3\":{\"visitdays\":\"2\",\"cate\":\"C10\",\"days_prop\":\"1.0000\"},\"month12\":{\"visitdays\":\"2\",\"cate\":\"C10\",\"days_prop\":\"1.0000\"}},\"month3\":{},\"month12\":{}},\"Media\":{\"month3\":{\"教育\":{\"visitdays\":\"2\"}},\"month6\":{\"教育\":{\"visitdays\":\"2\"}},\"month12\":{\"教育\":{\"visitdays\":\"2\"}}},\"Flag\":{\"core\":{\"key\":\"1\"},\"media_c\":\"1\",\"consumption_c\":\"1\",\"stability_c\":\"1\",\"specialList_c\":\"0\",\"accountChange\":\"1\",\"location\":\"1\",\"applyLoan\":\"0\",\"score\":\"1\"}}";
//		String str = "{\"code\":\"00\",\"swift_number\":\"100179_20151218081452_0304\",\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"tel_biz\":\"0\",\"tel_home\":\"1\"},\"Location\":{\"home_addr\":{\"addr11\":\"3.0\",\"addr12\":\"3.1\",\"addr13\":\"4.2\",\"addr14\":\"17.9\",\"addr15\":\"137.4\"},\"biz_addr\":{\"addr21\":\"22.8\",\"addr22\":\"26.0\",\"addr23\":\"26.3\",\"addr24\":\"26.9\",\"addr25\":\"27.4\"},\"per_addr\":{},\"apply_addr\":{},\"oth_addr\":{}},\"Stability_c\":{\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"id-name\":\"0\",\"biz_tel\":\"0\",\"home_tel\":\"1\"},\"id\":{\"number\":\"2\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"\"},\"mail\":{\"number\":\"0\"},\"name\":{\"number\":\"1778\"},\"tel\":{\"number\":\"510\"},\"addr\":{\"number\":\"366\"}},\"Stability\":{\"id\":{\"number\":\"2\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"\"},\"mail\":{\"number\":\"0\"},\"name\":{\"number\":\"1778\"},\"tel\":{\"number\":\"510\"},\"addr\":{\"number\":\"366\"}},\"Consumption_c\":{\"continue\":\"M4\",\"time_recent\":\"T1\",\"total\":{\"month3\":{\"visits\":\"6622\",\"number\":\"431\",\"pay\":\"20000\",\"p_catenum\":\"23\",\"v_catenum\":\"25\"},\"month12\":{\"visits\":\"22981\",\"number\":\"2497\",\"pay\":\"200000\",\"p_catenum\":\"27\",\"v_catenum\":\"27\"}},\"max\":{\"month3\":{\"number\":\"95\",\"pay\":\"3000\",\"paycate\":\"C7\"},\"month12\":{\"number\":\"858\",\"pay\":\"50000\",\"paycate\":\"C7\"}},\"month3\":{\"家用电器\":{\"number\":\"3\",\"pay\":\"300\"},\"日用百货\":{\"number\":\"16\",\"pay\":\"800\"},\"母婴用品\":{\"number\":\"95\",\"pay\":\"1000\"}},\"month12\":{\"家用电器\":{\"number\":\"23\",\"pay\":\"6000\"},\"日用百货\":{\"number\":\"73\",\"pay\":\"3000\"},\"母婴用品\":{\"number\":\"161\",\"pay\":\"6000\"}}},\"Consumption\":{\"month3\":{\"箱包\":{\"visits\":\"299\",\"number\":\"3\",\"pay\":\"500\"},\"宠物生活\":{\"visits\":\"25\",\"number\":\"21\",\"pay\":\"4\"},\"本地生活\":{\"visits\":\"0\",\"number\":\"1\",\"pay\":\"30\"},\"通讯\":{\"visits\":\"24\",\"number\":\"63\",\"pay\":\"3000\"},\"个护化妆\":{\"visits\":\"122\",\"number\":\"2\",\"pay\":\"50\"},\"钟表首饰\":{\"visits\":\"300\",\"number\":\"18\",\"pay\":\"40\"},\"汽车用品\":{\"visits\":\"59\",\"number\":\"10\",\"pay\":\"800\"},\"电脑/办公\":{\"visits\":\"127\",\"number\":\"16\",\"pay\":\"80\"},\"其他\":{\"visits\":\"66\",\"number\":\"23\",\"pay\":\"20\"},\"家具建材\":{\"visits\":\"202\",\"number\":\"14\",\"pay\":\"1000\"},\"鞋\":{\"visits\":\"550\",\"number\":\"7\",\"pay\":\"3000\"},\"文化娱乐\":{\"visits\":\"28\",\"number\":\"4\",\"pay\":\"50\"},\"数码\":{\"visits\":\"91\",\"number\":\"6\",\"pay\":\"500\"},\"美食特产\":{\"visits\":\"297\",\"number\":\"63\",\"pay\":\"600\"},\"服装配饰\":{\"visits\":\"2199\",\"number\":\"25\",\"pay\":\"3000\"},\"珠宝贵金属\":{\"visits\":\"12\",\"number\":\"0\",\"pay\":\"0\"},\"运动户外\":{\"visits\":\"300\",\"number\":\"15\",\"pay\":\"900\"},\"收藏\":{\"visits\":\"2\",\"number\":\"0\",\"pay\":\"0\"},\"医疗保健\":{\"visits\":\"43\",\"number\":\"6\",\"pay\":\"400\"},\"手机/手机配件\":{\"visits\":\"194\",\"number\":\"2\",\"pay\":\"200\"},\"母婴用品\":{\"visits\":\"1083\",\"number\":\"95\",\"pay\":\"1000\"},\"网络游戏/虚拟物品\":{\"visits\":\"23\",\"number\":\"9\",\"pay\":\"200\"},\"教育培训\":{\"visits\":\"8\",\"number\":\"0\",\"pay\":\"0\"},\"家用电器\":{\"visits\":\"137\",\"number\":\"3\",\"pay\":\"300\"},\"日用百货\":{\"visits\":\"253\",\"number\":\"16\",\"pay\":\"800\"},\"家居家纺\":{\"visits\":\"178\",\"number\":\"9\",\"pay\":\"200\"}},\"month6\":{\"箱包\":{\"visits\":\"676\",\"number\":\"5\",\"pay\":\"900\"},\"宠物生活\":{\"visits\":\"25\",\"number\":\"21\",\"pay\":\"4\"},\"本地生活\":{\"visits\":\"1\",\"number\":\"1\",\"pay\":\"30\"},\"通讯\":{\"visits\":\"38\",\"number\":\"139\",\"pay\":\"7000\"},\"个护化妆\":{\"visits\":\"265\",\"number\":\"30\",\"pay\":\"1000\"},\"钟表首饰\":{\"visits\":\"489\",\"number\":\"21\",\"pay\":\"2000\"},\"汽车用品\":{\"visits\":\"151\",\"number\":\"27\",\"pay\":\"1000\"},\"电脑/办公\":{\"visits\":\"342\",\"number\":\"48\",\"pay\":\"1000\"},\"其他\":{\"visits\":\"136\",\"number\":\"75\",\"pay\":\"3000\"},\"出差旅游\":{\"visits\":\"12\",\"number\":\"4\",\"pay\":\"6000\"},\"家具建材\":{\"visits\":\"330\",\"number\":\"63\",\"pay\":\"30000\"},\"鞋\":{\"visits\":\"903\",\"number\":\"12\",\"pay\":\"4000\"},\"文化娱乐\":{\"visits\":\"101\",\"number\":\"13\",\"pay\":\"700\"},\"数码\":{\"visits\":\"159\",\"number\":\"9\",\"pay\":\"600\"},\"美食特产\":{\"visits\":\"552\",\"number\":\"132\",\"pay\":\"1000\"},\"服装配饰\":{\"visits\":\"4332\",\"number\":\"78\",\"pay\":\"20000\"},\"珠宝贵金属\":{\"visits\":\"54\",\"number\":\"0\",\"pay\":\"0\"},\"运动户外\":{\"visits\":\"533\",\"number\":\"20\",\"pay\":\"3000\"},\"收藏\":{\"visits\":\"11\",\"number\":\"3\",\"pay\":\"200\"},\"医疗保健\":{\"visits\":\"59\",\"number\":\"8\",\"pay\":\"500\"},\"手机/手机配件\":{\"visits\":\"372\",\"number\":\"9\",\"pay\":\"5000\"},\"母婴用品\":{\"visits\":\"1733\",\"number\":\"125\",\"pay\":\"4000\"},\"网络游戏/虚拟物品\":{\"visits\":\"54\",\"number\":\"787\",\"pay\":\"1000\"},\"教育培训\":{\"visits\":\"27\",\"number\":\"0\",\"pay\":\"0\"},\"家用电器\":{\"visits\":\"277\",\"number\":\"12\",\"pay\":\"2000\"},\"日用百货\":{\"visits\":\"509\",\"number\":\"45\",\"pay\":\"1000\"},\"家居家纺\":{\"visits\":\"236\",\"number\":\"11\",\"pay\":\"900\"}},\"month12\":{\"箱包\":{\"visits\":\"989\",\"number\":\"11\",\"pay\":\"4000\",\"maxpay\":\"2000\"},\"宠物生活\":{\"visits\":\"43\",\"number\":\"22\",\"pay\":\"30\",\"maxpay\":\"30\"},\"本地生活\":{\"visits\":\"15\",\"number\":\"4\",\"pay\":\"200\",\"maxpay\":\"100\"},\"通讯\":{\"visits\":\"71\",\"number\":\"242\",\"pay\":\"10000\",\"maxpay\":\"2000\"},\"个护化妆\":{\"visits\":\"445\",\"number\":\"70\",\"pay\":\"4000\",\"maxpay\":\"2000\"},\"钟表首饰\":{\"visits\":\"796\",\"number\":\"30\",\"pay\":\"3000\",\"maxpay\":\"2000\"},\"汽车用品\":{\"visits\":\"404\",\"number\":\"34\",\"pay\":\"3000\",\"maxpay\":\"1000\"},\"电脑/办公\":{\"visits\":\"683\",\"number\":\"129\",\"pay\":\"10000\",\"maxpay\":\"5000\"},\"其他\":{\"visits\":\"296\",\"number\":\"95\",\"pay\":\"4000\",\"maxpay\":\"2000\"},\"出差旅游\":{\"visits\":\"13\",\"number\":\"12\",\"pay\":\"6000\",\"maxpay\":\"3000\"},\"家具建材\":{\"visits\":\"839\",\"number\":\"106\",\"pay\":\"30000\",\"maxpay\":\"10000\"},\"鞋\":{\"visits\":\"1624\",\"number\":\"41\",\"pay\":\"10000\",\"maxpay\":\"3000\"},\"文化娱乐\":{\"visits\":\"253\",\"number\":\"38\",\"pay\":\"1000\",\"maxpay\":\"300\"},\"数码\":{\"visits\":\"328\",\"number\":\"31\",\"pay\":\"1000\",\"maxpay\":\"500\"},\"美食特产\":{\"visits\":\"1120\",\"number\":\"191\",\"pay\":\"4000\",\"maxpay\":\"900\"},\"服装配饰\":{\"visits\":\"8479\",\"number\":\"213\",\"pay\":\"50000\",\"maxpay\":\"10000\"},\"珠宝贵金属\":{\"visits\":\"193\",\"number\":\"1\",\"pay\":\"100\",\"maxpay\":\"100\"},\"运动户外\":{\"visits\":\"799\",\"number\":\"37\",\"pay\":\"6000\",\"maxpay\":\"2000\"},\"收藏\":{\"visits\":\"51\",\"number\":\"3\",\"pay\":\"200\",\"maxpay\":\"200\"},\"医疗保健\":{\"visits\":\"75\",\"number\":\"8\",\"pay\":\"500\",\"maxpay\":\"300\"},\"手机/手机配件\":{\"visits\":\"567\",\"number\":\"29\",\"pay\":\"7000\",\"maxpay\":\"5000\"},\"母婴用品\":{\"visits\":\"2489\",\"number\":\"161\",\"pay\":\"6000\",\"maxpay\":\"2000\"},\"网络游戏/虚拟物品\":{\"visits\":\"213\",\"number\":\"858\",\"pay\":\"2000\",\"maxpay\":\"600\"},\"教育培训\":{\"visits\":\"88\",\"number\":\"3\",\"pay\":\"900\",\"maxpay\":\"900\"},\"家用电器\":{\"visits\":\"548\",\"number\":\"23\",\"pay\":\"6000\",\"maxpay\":\"3000\"},\"日用百货\":{\"visits\":\"791\",\"number\":\"73\",\"pay\":\"3000\",\"maxpay\":\"800\"},\"家居家纺\":{\"visits\":\"769\",\"number\":\"32\",\"pay\":\"1000\",\"maxpay\":\"300\"}},\"level\":{\"宠物生活\":\"0.0370\",\"箱包\":\"0.7223\",\"本地生活\":\"0.2331\",\"通讯\":\"0.9927\",\"个护化妆\":\"0.9966\",\"钟表首饰\":\"0.2791\",\"汽车用品\":\"0.7308\",\"出差旅游\":\"0.9693\",\"其他\":\"0.4849\",\"电脑/办公\":\"0.4741\",\"家具建材\":\"0.8373\",\"鞋\":\"0.9657\",\"文化娱乐\":\"0.9989\",\"数码\":\"0.8163\",\"美食特产\":\"0.7700\",\"服装配饰\":\"0.7422\",\"收藏\":\"0.7056\",\"珠宝贵金属\":\"0.2113\",\"运动户外\":\"0.6588\",\"医疗保健\":\"0.9011\",\"手机/手机配件\":\"0.5593\",\"母婴用品\":\"0.7294\",\"网络游戏/虚拟物品\":\"0.5055\",\"教育培训\":\"0.9523\",\"家用电器\":\"0.3736\",\"日用百货\":\"0.9547\",\"家居家纺\":\"0.5614\"}},\"ApplyLoan\":{\"month3\":{\"cell\":{\"bank\":{\"selfnumber\":\"0\",\"allnumber\":\"1\",\"orgnumber\":\"1\"},\"notbank\":{\"selfnumber\":\"0\",\"allnumber\":\"4\",\"orgnumber\":\"2\"}}},\"month6\":{\"cell\":{\"bank\":{\"selfnumber\":\"0\",\"allnumber\":\"1\",\"orgnumber\":\"1\"},\"notbank\":{\"selfnumber\":\"0\",\"allnumber\":\"4\",\"orgnumber\":\"2\"}}},\"month12\":{\"cell\":{\"bank\":{\"selfnumber\":\"0\",\"allnumber\":\"1\",\"orgnumber\":\"1\"},\"notbank\":{\"selfnumber\":\"0\",\"allnumber\":\"4\",\"orgnumber\":\"2\"}}}},\"SpecialList_c\":{},\"Score\":{\"bankpfpoint\":\"675\"},\"Accountchange\":{},\"Assets\":{\"house\":\"2\",\"car\":\"2\",\"fin\":\"1\",\"wealth\":\"3\"},\"Media_c\":{\"total\":{\"month3\":{\"visitdays\":\"18\",\"catenum\":\"5\"},\"month12\":{\"visitdays\":\"136\",\"catenum\":\"15\"}},\"max\":{\"month3\":{\"visitdays\":\"7\",\"cate\":\"C24\",\"days_prop\":\"0.3889\"},\"month12\":{\"visitdays\":\"25\",\"cate\":\"C10\",\"days_prop\":\"0.1838\"}},\"month3\":{\"文学艺术\":{\"visitdays\":\"7\"},\"母婴/育儿\":{\"visitdays\":\"4\"}},\"month12\":{\"财经\":{\"visitdays\":\"16\"},\"文学艺术\":{\"visitdays\":\"23\"},\"母婴/育儿\":{\"visitdays\":\"22\"}}},\"Media\":{\"month3\":{\"健康\":{\"visitdays\":\"1\"},\"教育\":{\"visitdays\":\"5\"},\"文学艺术\":{\"visitdays\":\"7\"},\"社区\":{\"visitdays\":\"1\"},\"母婴/育儿\":{\"visitdays\":\"4\"}},\"month6\":{\"健康\":{\"visitdays\":\"2\"},\"财经\":{\"visitdays\":\"4\"},\"教育\":{\"visitdays\":\"11\"},\"文学艺术\":{\"visitdays\":\"12\"},\"社区\":{\"visitdays\":\"4\"},\"IT\":{\"visitdays\":\"2\"},\"母婴/育儿\":{\"visitdays\":\"8\"}},\"month12\":{\"新闻\":{\"visitdays\":\"4\"},\"旅游\":{\"visitdays\":\"1\"},\"健康\":{\"visitdays\":\"7\"},\"IT\":{\"visitdays\":\"2\"},\"历史\":{\"visitdays\":\"1\"},\"生活\":{\"visitdays\":\"8\"},\"教育\":{\"visitdays\":\"25\"},\"财经\":{\"visitdays\":\"16\"},\"动漫\":{\"visitdays\":\"3\"},\"游戏\":{\"visitdays\":\"5\"},\"文学艺术\":{\"visitdays\":\"23\"},\"社区\":{\"visitdays\":\"16\"},\"交友\":{\"visitdays\":\"2\"},\"知识问答\":{\"visitdays\":\"1\"},\"母婴/育儿\":{\"visitdays\":\"22\"}}},\"Flag\":{\"core\":{\"key\":\"1\"},\"media_c\":\"1\",\"consumption_c\":\"1\",\"stability_c\":\"1\",\"specialList_c\":\"0\",\"accountChange\":\"0\",\"location\":\"1\",\"applyLoan\":\"1\",\"score\":\"1\"}}";
//		String str = "{\"code\":\"100002\",\"swift_number\":\"100179_20151218081523_0423\",\"Authentication\":{},\"Location\":{},\"Stability_c\":{},\"Stability\":{},\"Consumption_c\":{},\"Consumption\":{},\"ApplyLoan\":{},\"SpecialList_c\":{},\"Score\":{},\"Accountchange\":{},\"Assets\":{},\"Media_c\":{},\"Media\":{},\"Flag\":{\"core\":{\"key\":\"0\"},\"media_c\":\"0\",\"consumption_c\":\"0\",\"stability_c\":\"0\",\"specialList_c\":\"0\",\"accountChange\":\"0\",\"location\":\"0\",\"applyLoan\":\"0\",\"score\":\"0\"}}";
//		String str = "{\"code\":\"00\",\"swift_number\":\"100179_20151217150735_5886\",\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"tel_biz\":\"0\",\"tel_home\":\"0\"},\"Location\":{\"home_addr\":{\"addr11\":\"15.8\"},\"biz_addr\":{\"addr21\":\"271.7\"},\"per_addr\":{},\"apply_addr\":{},\"oth_addr\":{}},\"Stability_c\":{\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"id-name\":\"0\",\"biz_tel\":\"0\",\"home_tel\":\"0\"},\"id\":{\"number\":\"0\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"2009\"},\"mail\":{\"number\":\"1\"},\"name\":{\"number\":\"1\"},\"tel\":{\"number\":\"0\"},\"addr\":{\"number\":\"1\"}},\"Stability\":{\"id\":{\"number\":\"0\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"2009\"},\"mail\":{\"number\":\"1\"},\"name\":{\"number\":\"1\"},\"tel\":{\"number\":\"0\"},\"addr\":{\"number\":\"1\"}},\"Consumption_c\":{\"continue\":\"M1\",\"time_recent\":\"T1\",\"total\":{\"month3\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"p_catenum\":\"1\",\"v_catenum\":\"1\"},\"month12\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"p_catenum\":\"1\",\"v_catenum\":\"1\"}},\"max\":{\"month3\":{\"number\":\"1\",\"pay\":\"10\",\"paycate\":\"C22\"},\"month12\":{\"number\":\"1\",\"pay\":\"10\",\"paycate\":\"C22\"}},\"month3\":{},\"month12\":{}},\"Consumption\":{\"month3\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\"}},\"month6\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\"}},\"month12\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"maxpay\":\"10\"}},\"level\":{\"文化娱乐\":\"0.0724\"}},\"ApplyLoan\":{},\"SpecialList_c\":{},\"Score\":{\"bankpfpoint\":\"751\"},\"Accountchange\":{\"cardindex\":\"4\",\"regionno\":\"0021\",\"m1m3\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"03\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"20\",\"outgo\":\"20\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m4m6\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"01\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"38\",\"outgo\":\"38\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m7m9\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"24\",\"outgo\":\"23\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m10m12\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"25\",\"outgo\":\"25\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m13m15\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"12\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"22\",\"outgo\":\"21\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m16m18\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"23\",\"outgo\":\"24\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"}},\"Assets\":{\"house\":\"0\",\"car\":\"0\",\"fin\":\"0\",\"wealth\":\"0\"},\"Media_c\":{\"total\":{\"month3\":{\"visitdays\":\"2\",\"catenum\":\"1\"},\"month12\":{\"visitdays\":\"2\",\"catenum\":\"1\"}},\"max\":{\"month3\":{\"visitdays\":\"2\",\"cate\":\"C10\",\"days_prop\":\"1.0000\"},\"month12\":{\"visitdays\":\"2\",\"cate\":\"C10\",\"days_prop\":\"1.0000\"}},\"month3\":{},\"month12\":{}},\"Media\":{\"month3\":{\"教育\":{\"visitdays\":\"2\"}},\"month6\":{\"教育\":{\"visitdays\":\"2\"}},\"month12\":{\"教育\":{\"visitdays\":\"2\"}}},\"Flag\":{\"core\":{\"key\":\"1\"},\"media_c\":\"1\",\"consumption_c\":\"1\",\"stability_c\":\"1\",\"specialList_c\":\"0\",\"accountChange\":\"1\",\"location\":\"1\",\"applyLoan\":\"0\",\"score\":\"1\"}}";
//		BairongRecord record = JSONArray.parseObject(str, BairongRecord.class);
//		System.out.println(parseBairong(record));
		
		String str = "APPID|ID|CELL|MAIL|NAME|GID|BR_QUERY_DATE|SPECIALLISTC_ID_BANKBAD|SPECIALLISTC_ID_BANKOVERDUE|SPECIALLISTC_ID_BANKFRAUD|SPECIALLISTC_ID_BANKLOST|SPECIALLISTC_ID_BANK_REFUSE|SPECIALLISTC_ID_CREDITBAD|SPECIALLISTC_ID_P2PBAD|SPECIALLISTC_ID_P2POVERDUE|SPECIALLISTC_ID_P2PFRAUD|SPECIALLISTC_ID_P2PLOST|SPECIALLISTC_ID_P2PREFUSE|SPECIALLISTC_ID_PHONEOVERDUE|SPECIALLISTC_ID_INSURANCEFRAUD|SPECIALLISTC_ID_COURTBAD|SPECIALLISTC_ID_COURTEXECUTED|SPECIALLISTC_CELL_BANKBAD|SPECIALLISTC_CELL_BANKOVERDUE|SPECIALLISTC_CELL_BANKFRAUD|SPECIALLISTC_CELL_BANKLOST|SPECIALLISTC_CELL_BANKREFUSE|SPECIALLISTC_CELL_P2POVERDUE|SPECIALLISTC_CELL_P2PFRAUD|SPECIALLISTC_CELL_INSURANCEFRAUD|SPECIALLISTC_CELL_P2PBAD|SPECIALLISTC_CELL_P2PLOST|SPECIALLISTC_CELL_P2PREFUSE|SPECIALLISTC_GID_BANKBAD|SPECIALLISTC_GID_BANKOVERDUE|SPECIALLISTC_GID_BANKFRAUD|SPECIALLISTC_GID_BANKLOST|SPECIALLISTC_GID_BANKREFUSE|SPECIALLISTC_GID_P2POVERDUE|SPECIALLISTC_GID_P2PFRAUD|SPECIALLISTC_GID_INSURANCEFRAUD|SPECIALLISTC_GID_P2PBAD|SPECIALLISTC_GID_P2PLOST|SPECIALLISTC_GID_P2PREFUSE|APPLYLOAN_MONTH3_ID_BANK_SELFNUMBER|APPLYLOAN_MONTH3_ID_BANK_ALLNUMBER|APPLYLOAN_MONTH3_ID_BANK_ORGNUMBER|APPLYLOAN_MONTH3_ID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH3_ID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH3_ID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH6_ID_BANK_SELFNUMBER|APPLYLOAN_MONTH6_ID_BANK_ALLNUMBER|APPLYLOAN_MONTH6_ID_BANK_ORGNUMBER|APPLYLOAN_MONTH6_ID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH6_ID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH6_ID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH12_ID_BANK_SELFNUMBER|APPLYLOAN_MONTH12_ID_BANK_ALLNUMBER|APPLYLOAN_MONTH12_ID_BANK_ORGNUMBER|APPLYLOAN_MONTH12_ID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH12_ID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH12_ID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH3_CELL_BANK_SELFNUMBER|APPLYLOAN_MONTH3_CELL_BANK_ALLNUMBER|APPLYLOAN_MONTH3_CELL_BANK_ORGNUMBER|APPLYLOAN_MONTH3_CELL_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH3_CELL_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH3_CELL_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH6_CELL_BANK_SELFNUMBER|APPLYLOAN_MONTH6_CELL_BANK_ALLNUMBER|APPLYLOAN_MONTH6_CELL_BANK_ORGNUMBER|APPLYLOAN_MONTH6_CELL_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH6_CELL_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH6_CELL_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH12_CELL_BANK_SELFNUMBER|APPLYLOAN_MONTH12_CELL_BANK_ALLNUMBER|APPLYLOAN_MONTH12_CELL_BANK_ORGNUMBER|APPLYLOAN_MONTH12_CELL_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH12_CELL_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH12_CELL_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH3_GID_BANK_SELFNUMBER|APPLYLOAN_MONTH3_GID_BANK_ALLNUMBER|APPLYLOAN_MONTH3_GID_BANK_ORGNUMBER|APPLYLOAN_MONTH3_GID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH3_GID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH3_GID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH6_GID_BANK_SELFNUMBER|APPLYLOAN_MONTH6_GID_BANK_ALLNUMBER|APPLYLOAN_MONTH6_GID_BANK_ORGNUMBER|APPLYLOAN_MONTH6_GID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH6_GID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH6_GID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH12_GID_BANK_SELFNUMBER|APPLYLOAN_MONTH12_GID_BANK_ALLNUMBER|APPLYLOAN_MONTH12_GID_BANK_ORGNUMBER|APPLYLOAN_MONTH12_GID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH12_GID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH12_GID_NOTBANK_ORGNUMBER|LOCATION_HOMEADDR_ADDR11|LOCATION_HOMEADDR_ADDR12|LOCATION_BIZADDR_ADDR21|LOCATION_BIZADDR_ADDR22|LOCATION_PERADDR_ADDR31|LOCATION_PERADDR_ADDR32|LOCATION_APPLYADDR_ADDR41|LOCATION_APPLYADDR_ADDR42|LOCATION_OTHADDR_ADDR51|LOCATION_OTHADDR_ADDR52|STABILITYC_AUTHENTICATION_ID|STABILITYC_AUTHENTICATION_CELL|STABILITYC_AUTHENTICATION_MAIL|STABILITYC_AUTHENTICATION_KEYRELATION|STABILITYC_AUTHENTICATION_NAME|STABILITYC_AUTHENTICATION_BIZTEL|STABILITYC_AUTHENTICATION_HOMETEL|STABILITYC_AUTHENTICATION_IDNAME|STABILITYC_ID_NUMBER|STABILITYC_CELL_NUMBER|STABILITYC_CELL_FIRSTTIME|STABILITYC_MAIL_NUMBER|STABILITYC_NAME_NUMBER|STABILITYC_TEL_NUMBER|STABILITYC_ADDR_NUMBER|MEDIAC_MAX_MONTH3_VISITDAYS|MEDIAC_MAX_MONTH3_CATE|MEDIAC_MAX_MONTH3_DAYSPROP|MEDIAC_MAX_MONTH12_VISITDAYS|MEDIAC_MAX_MONTH12_CATE|MEDIAC_MAX_MONTH12_DAYSPROP|MEDIAC_TOTAL_MONTH3_VISITDAYS|MEDIAC_TOTAL_MONTH3_CATENUM|MEDIAC_TOTAL_MONTH12_VISITDAYS|MEDIAC_TOTAL_MONTH12_CATENUM|CONSUMPTIONC_CONTINUE|CONSUMPTIONC_TIMERECENT|CONSUMPTIONC_MAX_MONTH3_NUMBER|CONSUMPTIONC_MAX_MONTH3_PAY|CONSUMPTIONC_MAX_MONTH3_PAYCATE|CONSUMPTIONC_MAX_MONTH12_NUMBER|CONSUMPTIONC_MAX_MONTH12_PAY|CONSUMPTIONC_MAX_MONTH12_PAYCATE|CONSUMPTIONC_TOTAL_MONTH3_VISITS|CONSUMPTIONC_TOTAL_MONTH3_NUMBER|CONSUMPTIONC_TOTAL_MONTH3_PAY|CONSUMPTIONC_TOTAL_MONTH3_PCATENUM|CONSUMPTIONC_TOTAL_MONTH3_VCATENUM|CONSUMPTIONC_TOTAL_MONTH12_VISITS|CONSUMPTIONC_TOTAL_MONTH12_NUMBER|CONSUMPTIONC_TOTAL_MONTH12_PAY|CONSUMPTIONC_TOTAL_MONTH12_PCATENUM|CONSUMPTIONC_TOTAL_MONTH12_VCATENUM|ACCOUNTCHANGE_CARDINDEX|ACCOUNTCHANGE_REGIONNO|ACCOUNTCHANGE_M1M3_LOAN|ACCOUNTCHANGE_M1M3_CREDITCARD_CASH|ACCOUNTCHANGE_M1M3_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M1M3_CREDITCARD_INCOME|ACCOUNTCHANGE_M1M3_CREDITCARD_OUTGO|ACCOUNTCHANGE_M1M3_CREDITCARD_STATUS|ACCOUNTCHANGE_M1M3_DEBITCARD_BALANCE|ACCOUNTCHANGE_M1M3_DEBITCARD_INCOME|ACCOUNTCHANGE_M1M3_DEBITCARD_OUTGO|ACCOUNTCHANGE_M1M3_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M1M3_DEBITCARD_REPAY|ACCOUNTCHANGE_M4M6_LOAN|ACCOUNTCHANGE_M4M6_CREDITCARD_CASH|ACCOUNTCHANGE_M4M6_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M4M6_CREDITCARD_INCOME|ACCOUNTCHANGE_M4M6_CREDITCARD_OUTGO|ACCOUNTCHANGE_M4M6_CREDITCARD_STATUS|ACCOUNTCHANGE_M4M6_DEBITCARD_BALANCE|ACCOUNTCHANGE_M4M6_DEBITCARD_INCOME|ACCOUNTCHANGE_M4M6_DEBITCARD_OUTGO|ACCOUNTCHANGE_M4M6_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M4M6_DEBITCARD_REPAY|ACCOUNTCHANGE_M7M9_LOAN|ACCOUNTCHANGE_M7M9_CREDITCARD_CASH|ACCOUNTCHANGE_M7M9_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M7M9_CREDITCARD_INCOME|ACCOUNTCHANGE_M7M9_CREDITCARD_OUTGO|ACCOUNTCHANGE_M7M9_CREDITCARD_STATUS|ACCOUNTCHANGE_M7M9_DEBITCARD_BALANCE|ACCOUNTCHANGE_M7M9_DEBITCARD_INCOME|ACCOUNTCHANGE_M7M9_DEBITCARD_OUTGO|ACCOUNTCHANGE_M7M9_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M7M9_DEBITCARD_REPAY|ACCOUNTCHANGE_M10M12_LOAN|ACCOUNTCHANGE_M10M12_CREDITCARD_CASH|ACCOUNTCHANGE_M10M12_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M10M12_CREDITCARD_INCOME|ACCOUNTCHANGE_M10M12_CREDITCARD_OUTGO|ACCOUNTCHANGE_M10M12_CREDITCARD_STATUS|ACCOUNTCHANGE_M10M12_DEBITCARD_BALANCE|ACCOUNTCHANGE_M10M12_DEBITCARD_INCOME|ACCOUNTCHANGE_M10M12_DEBITCARD_OUTGO|ACCOUNTCHANGE_M10M12_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M10M12_DEBITCARD_REPAY|ACCOUNTCHANGE_M13M15_LOAN|ACCOUNTCHANGE_M13M15_CREDITCARD_CASH|ACCOUNTCHANGE_M13M15_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M13M15_CREDITCARD_INCOME|ACCOUNTCHANGE_M13M15_CREDITCARD_OUTGO|ACCOUNTCHANGE_M13M15_CREDITCARD_STATUS|ACCOUNTCHANGE_M13M15_DEBITCARD_BALANCE|ACCOUNTCHANGE_M13M15_DEBITCARD_INCOME|ACCOUNTCHANGE_M13M15_DEBITCARD_OUTGO|ACCOUNTCHANGE_M13M15_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M13M15_DEBITCARD_REPAY|ACCOUNTCHANGE_M16M18_LOAN|ACCOUNTCHANGE_M16M18_CREDITCARD_CASH|ACCOUNTCHANGE_M16M18_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M16M18_CREDITCARD_INCOME|ACCOUNTCHANGE_M16M18_CREDITCARD_OUTGO|ACCOUNTCHANGE_M16M18_CREDITCARD_STATUS|ACCOUNTCHANGE_M16M18_DEBITCARD_BALANCE|ACCOUNTCHANGE_M16M18_DEBITCARD_INCOME|ACCOUNTCHANGE_M16M18_DEBITCARD_OUTGO|ACCOUNTCHANGE_M16M18_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M16M18_DEBITCARD_REPAY|PAYCONSUMPTION_THM1_PAY|PAYCONSUMPTION_THM1_NUMBER|PAYCONSUMPTION_THM1_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM1_FIRST_PAYMCC|PAYCONSUMPTION_THM1_FIRST_NUMBERMCC|PAYCONSUMPTION_THM1_SECOND_PAYMCC|PAYCONSUMPTION_THM1_SECOND_NUMBERMCC|PAYCONSUMPTION_THM1_THIRD_PAYMCC|PAYCONSUMPTION_THM1_THIRD_NUMBERMCC|PAYCONSUMPTION_THM1_NIGHT_PAY|PAYCONSUMPTION_THM1_NIGHT_NUMBER|PAYCONSUMPTION_THM2_PAY|PAYCONSUMPTION_THM2_NUMBER|PAYCONSUMPTION_THM2_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM2_FIRST_PAYMCC|PAYCONSUMPTION_THM2_FIRST_NUMBERMCC|PAYCONSUMPTION_THM2_SECOND_PAYMCC|PAYCONSUMPTION_THM2_SECOND_NUMBERMCC|PAYCONSUMPTION_THM2_THIRD_PAYMCC|PAYCONSUMPTION_THM2_THIRD_NUMBERMCC|PAYCONSUMPTION_THM2_NIGHT_PAY|PAYCONSUMPTION_THM2_NIGHT_NUMBER|PAYCONSUMPTION_THM3_PAY|PAYCONSUMPTION_THM3_NUMBER|PAYCONSUMPTION_THM3_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM3_FIRST_PAYMCC|PAYCONSUMPTION_THM3_FIRST_NUMBERMCC|PAYCONSUMPTION_THM3_SECOND_PAYMCC|PAYCONSUMPTION_THM3_SECOND_NUMBERMCC|PAYCONSUMPTION_THM3_THIRD_PAYMCC|PAYCONSUMPTION_THM3_THIRD_NUMBERMCC|PAYCONSUMPTION_THM3_NIGHT_PAY|PAYCONSUMPTION_THM3_NIGHT_NUMBER|PAYCONSUMPTION_THM4_PAY|PAYCONSUMPTION_THM4_NUMBER|PAYCONSUMPTION_THM4_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM4_FIRST_PAYMCC|PAYCONSUMPTION_THM4_FIRST_NUMBERMCC|PAYCONSUMPTION_THM4_SECOND_PAYMCC|PAYCONSUMPTION_THM4_SECOND_NUMBERMCC|PAYCONSUMPTION_THM4_THIRD_PAYMCC|PAYCONSUMPTION_THM4_THIRD_NUMBERMCC|PAYCONSUMPTION_THM4_NIGHT_PAY|PAYCONSUMPTION_THM4_NIGHT_NUMBER|PAYCONSUMPTION_THM5_PAY|PAYCONSUMPTION_THM5_NUMBER|PAYCONSUMPTION_THM5_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM5_FIRST_PAYMCC|PAYCONSUMPTION_THM5_FIRST_NUMBERMCC|PAYCONSUMPTION_THM5_SECOND_PAYMCC|PAYCONSUMPTION_THM5_SECOND_NUMBERMCC|PAYCONSUMPTION_THM5_THIRD_PAYMCC|PAYCONSUMPTION_THM5_THIRD_NUMBERMCC|PAYCONSUMPTION_THM5_NIGHT_PAY|PAYCONSUMPTION_THM5_NIGHT_NUMBER|PAYCONSUMPTION_THM6_PAY|PAYCONSUMPTION_THM6_NUMBER|PAYCONSUMPTION_THM6_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM6_FIRST_PAYMCC|PAYCONSUMPTION_THM6_FIRST_NUMBERMCC|PAYCONSUMPTION_THM6_SECOND_PAYMCC|PAYCONSUMPTION_THM6_SECOND_NUMBERMCC|PAYCONSUMPTION_THM6_THIRD_PAYMCC|PAYCONSUMPTION_THM6_THIRD_NUMBERMCC|PAYCONSUMPTION_THM6_NIGHT_PAY|PAYCONSUMPTION_THM6_NIGHT_NUMBER|PAYCONSUMPTION_THM7_PAY|PAYCONSUMPTION_THM7_NUMBER|PAYCONSUMPTION_THM7_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM7_FIRST_PAYMCC|PAYCONSUMPTION_THM7_FIRST_NUMBERMCC|PAYCONSUMPTION_THM7_SECOND_PAYMCC|PAYCONSUMPTION_THM7_SECOND_NUMBERMCC|PAYCONSUMPTION_THM7_THIRD_PAYMCC|PAYCONSUMPTION_THM7_THIRD_NUMBERMCC|PAYCONSUMPTION_THM7_NIGHT_PAY|PAYCONSUMPTION_THM7_NIGHT_NUMBER|PAYCONSUMPTION_THM8_PAY|PAYCONSUMPTION_THM8_NUMBER|PAYCONSUMPTION_THM8_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM8_FIRST_PAYMCC|PAYCONSUMPTION_THM8_FIRST_NUMBERMCC|PAYCONSUMPTION_THM8_SECOND_PAYMCC|PAYCONSUMPTION_THM8_SECOND_NUMBERMCC|PAYCONSUMPTION_THM8_THIRD_PAYMCC|PAYCONSUMPTION_THM8_THIRD_NUMBERMCC|PAYCONSUMPTION_THM8_NIGHT_PAY|PAYCONSUMPTION_THM8_NIGHT_NUMBER|PAYCONSUMPTION_THM9_PAY|PAYCONSUMPTION_THM9_NUMBER|PAYCONSUMPTION_THM9_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM9_FIRST_PAYMCC|PAYCONSUMPTION_THM9_FIRST_NUMBERMCC|PAYCONSUMPTION_THM9_SECOND_PAYMCC|PAYCONSUMPTION_THM9_SECOND_NUMBERMCC|PAYCONSUMPTION_THM9_THIRD_PAYMCC|PAYCONSUMPTION_THM9_THIRD_NUMBERMCC|PAYCONSUMPTION_THM9_NIGHT_PAY|PAYCONSUMPTION_THM9_NIGHT_NUMBER|PAYCONSUMPTION_THM10_PAY|PAYCONSUMPTION_THM10_NUMBER|PAYCONSUMPTION_THM10_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM10_FIRST_PAYMCC|PAYCONSUMPTION_THM10_FIRST_NUMBERMCC|PAYCONSUMPTION_THM10_SECOND_PAYMCC|PAYCONSUMPTION_THM10_SECOND_NUMBERMCC|PAYCONSUMPTION_THM10_THIRD_PAYMCC|PAYCONSUMPTION_THM10_THIRD_NUMBERMCC|PAYCONSUMPTION_THM10_NIGHT_PAY|PAYCONSUMPTION_THM10_NIGHT_NUMBER|PAYCONSUMPTION_THM11_PAY|PAYCONSUMPTION_THM11_NUMBER|PAYCONSUMPTION_THM11_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM11_FIRST_PAYMCC|PAYCONSUMPTION_THM11_FIRST_NUMBERMCC|PAYCONSUMPTION_THM11_SECOND_PAYMCC|PAYCONSUMPTION_THM11_SECOND_NUMBERMCC|PAYCONSUMPTION_THM11_THIRD_PAYMCC|PAYCONSUMPTION_THM11_THIRD_NUMBERMCC|PAYCONSUMPTION_THM11_NIGHT_PAY|PAYCONSUMPTION_THM11_NIGHT_NUMBER|PAYCONSUMPTION_THM12_PAY|PAYCONSUMPTION_THM12_NUMBER|PAYCONSUMPTION_THM12_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM12_FIRST_PAYMCC|PAYCONSUMPTION_THM12_FIRST_NUMBERMCC|PAYCONSUMPTION_THM12_SECOND_PAYMCC|PAYCONSUMPTION_THM12_SECOND_NUMBERMCC|PAYCONSUMPTION_THM12_THIRD_PAYMCC|PAYCONSUMPTION_THM12_THIRD_NUMBERMCC|PAYCONSUMPTION_THM12_NIGHT_PAY|PAYCONSUMPTION_THM12_NIGHT_NUMBER|SCORE_BANKPFPOINT|AUTHENTICATION_ID|AUTHENTICATION_CELL|AUTHENTICATION_MAIL|AUTHENTICATION_KEYRELATION|AUTHENTICATION_NAME|AUTHENTICATION_BIZTEL|AUTHENTICATION_HOMETEL|AUTHENTICATION_IDNAME";
		System.out.println(str.toUpperCase());
		
	}
}
