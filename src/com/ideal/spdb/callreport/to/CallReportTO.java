package com.ideal.spdb.callreport.to;

import com.ideal.spdb.utils.BaseModel;

public class CallReportTO extends BaseModel{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String calltype;
		private String results;
		public String getCalltype() {
			return calltype;
		}
		public void setCalltype(String calltype) {
			this.calltype = calltype;
		}
		public String getResults() {
			return results;
		}
		public void setResults(String results) {
			this.results = results;
		}
		
		
}
