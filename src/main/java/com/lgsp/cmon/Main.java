package com.lgsp.cmon;
import java.util.List;

import org.wso2.client.api.ApiClient;
import org.wso2.client.api.ApiException;
import org.wso2.client.api.Configuration;
import org.wso2.client.api.Cmon.CapcoquanquanlysApi;
import org.wso2.client.api.Cmon.CoquanquanlysApi;
import org.wso2.client.api.Cmon.DantocsApi;
import org.wso2.client.api.Cmon.DonvidoluongsApi;
import org.wso2.client.api.Cmon.DonvihanhchinhsApi;
import org.wso2.client.api.Cmon.LoaidonvidoluongsApi;
import org.wso2.client.api.Cmon.TongiaosApi;
import org.wso2.client.model.Cmon.CapCoQuanQuanLy;
import org.wso2.client.model.Cmon.CoQuanQuanLy;
import org.wso2.client.model.Cmon.DanToc;
import org.wso2.client.model.Cmon.DonViDoLuong;
import org.wso2.client.model.Cmon.DonViHanhChinh;
import org.wso2.client.model.Cmon.LoaiDonViDoLuong;
import org.wso2.client.model.Cmon.TonGiao;

public class Main {
	public static void main(String[] args) {
		String adapterAddress = "https://api.lgsp.quangnam.gov.vn:8247";
		String key = "5nl1mqdYdNhZACbyAvydq9JzSloa"; // (1) Consumer key
		String secret = "StuEwUaidp2t4CQCNCSDjmlTeWsa"; // (2) Consumer secret
	    String url = adapterAddress + "/token"; // (3) URL get token
	    String accessToken = new AccessTokenJson(key, secret, url).generate().getToken();
	    System.out.println(accessToken);	    

		ApiClient defaultClient = Configuration.getDefaultApiClient();
	    defaultClient.addDefaultHeader("Authorization", "Bearer " + accessToken);
        defaultClient.setBasePath(adapterAddress + "/cmon/v1.0.0"); // (4) URL Base Path
        
        int run = 13;
        
        //1: Lấy danh sách cấp cơ quan quản lý
        //2: Lấy cấp cơ quan quản lý theo mã
        //3: Lấy danh sách đơn vị hành chính theo cấp (TINH, HUYEN, XA)
        //4: Lấy danh sách đơn vị hành chính theo cấp trên
        //5: Lấy đơn vị hành chính theo mã
        //6: Lấy danh sách cơ quan quản lý theo mã cấp cơ quan quản lý
        //7: Lấy danh sách cơ quan quản lý theo mã cơ quan quản lý cấp trên
        //8: Lấy cơ quan quản lý theo mã cơ quan quản lý
        //9: Lấy danh sách dân tộc
        //10: Lấy dân tộc theo ID
        //11: Lấy danh sách tôn giáo
        //12: Lấy tôn giáo theo ID
        //13: Lấy danh sách loại đơn vị đo lường
        //14: Lấy loại đơn vị đo lường theo ID
        //15: Lấy danh sách đơn vị đo lường
        //16: Lấy đơn vị đo lường theo ID
        
        switch (run) {
		case 1:
			// Lấy danh sách cấp cơ quan quản lý
			CapcoquanquanlysApi apiInstanceCapCoQuanQuanLy = new CapcoquanquanlysApi();
	        apiInstanceCapCoQuanQuanLy.setApiClient(defaultClient);
	        try {
	        	List<CapCoQuanQuanLy> listCapCoQuanQuanLy = apiInstanceCapCoQuanQuanLy.capcoquanquanlysGet();
	        	for (CapCoQuanQuanLy capCQQL : listCapCoQuanQuanLy) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + capCQQL.getId());
	        		System.out.println("ma: " + capCQQL.getMa());
	        		System.out.println("ten: " + capCQQL.getTen());
	        		System.out.println("cap: " + capCQQL.getCap());
	        		System.out.println("capTren: " + capCQQL.getCapTren());
	        	}
	        	
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 2:
			// Lấy cấp cơ quan quản lý theo mã
			CapcoquanquanlysApi apiInstanceCapCoQuanQuanLy2 = new CapcoquanquanlysApi();
			apiInstanceCapCoQuanQuanLy2.setApiClient(defaultClient);
	        try {
	        	CapCoQuanQuanLy capCQQL = apiInstanceCapCoQuanQuanLy2.capcoquanquanlysMaGet("002");
	        	if (capCQQL != null) {
	        		System.out.println("id: " + capCQQL.getId());
	        		System.out.println("ma: " + capCQQL.getMa());
	        		System.out.println("ten: " + capCQQL.getTen());
	        		System.out.println("cap: " + capCQQL.getCap());
	        		System.out.println("capTren: " + capCQQL.getCapTren());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 3:
			// Lấy danh sách đơn vị hành chính theo cấp (TINH, HUYEN, XA)
			DonvihanhchinhsApi apiDonViHanhChinh = new DonvihanhchinhsApi();
			apiDonViHanhChinh.setApiClient(defaultClient);
	        try {
	        	List<DonViHanhChinh> listDVHC = apiDonViHanhChinh.donvihanhchinhsCapCapGet("TINH");
	        	for (DonViHanhChinh dvhc : listDVHC) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + dvhc.getId());
	        		System.out.println("ma: " + dvhc.getMa());
	        		System.out.println("ten: " + dvhc.getTen());
	        		System.out.println("tenTA: " + dvhc.getTenTA());
	        		System.out.println("cap: " + dvhc.getCap());
	        		System.out.println("capTren: " + dvhc.getCapTren());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 4:
			// Lấy danh sách đơn vị hành chính theo cấp trên
			DonvihanhchinhsApi apiDonViHanhChinh2 = new DonvihanhchinhsApi();
			apiDonViHanhChinh2.setApiClient(defaultClient);
	        try {
	        	List<DonViHanhChinh> listDVHC = apiDonViHanhChinh2.donvihanhchinhsCapTrenCapTrenGet("49");
	        	for (DonViHanhChinh dvhc : listDVHC) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + dvhc.getId());
	        		System.out.println("ma: " + dvhc.getMa());
	        		System.out.println("ten: " + dvhc.getTen());
	        		System.out.println("tenTA: " + dvhc.getTenTA());
	        		System.out.println("cap: " + dvhc.getCap());
	        		System.out.println("capTren: " + dvhc.getCapTren());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 5:
			// Lấy đơn vị hành chính theo mã
			DonvihanhchinhsApi apiDonViHanhChinh3 = new DonvihanhchinhsApi();
			apiDonViHanhChinh3.setApiClient(defaultClient);
	        try {
	        	DonViHanhChinh dvhc = apiDonViHanhChinh3.donvihanhchinhsMaGet("49");
	        	if (dvhc != null) {
	        		System.out.println("id: " + dvhc.getId());
	        		System.out.println("ma: " + dvhc.getMa());
	        		System.out.println("ten: " + dvhc.getTen());
	        		System.out.println("tenTA: " + dvhc.getTenTA());
	        		System.out.println("cap: " + dvhc.getCap());
	        		System.out.println("capTren: " + dvhc.getCapTren());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 6:
			// Lấy danh sách cơ quan quản lý theo mã cấp cơ quan quản lý
			CoquanquanlysApi apiCoQuanQuanLy = new CoquanquanlysApi();
			apiCoQuanQuanLy.setApiClient(defaultClient);
	        try {
	        	List<CoQuanQuanLy> listCQQL = apiCoQuanQuanLy.coquanquanlysCapCapGet("002");
	        	for (CoQuanQuanLy cqql : listCQQL) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + cqql.getId());
	        		System.out.println("ma: " + cqql.getMa());
	        		System.out.println("ten: " + cqql.getTen());
	        		System.out.println("diaChi: " + cqql.getDiaChi());
	        		System.out.println("dienThoai: " + cqql.getDienThoai());
	        		System.out.println("email: " + cqql.getEmail());
	        		System.out.println("fax: " + cqql.getFax());
	        		System.out.println("website: " + cqql.getWebsite());
	        		System.out.println("cap: " + cqql.getCap());
	        		System.out.println("capTren: " + cqql.getCapTren());
	        		System.out.println("donViHanhChinh: " + cqql.getDonViHanhChinh());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 7:
			// Lấy danh sách cơ quan quản lý theo mã cơ quan quản lý cấp trên
			CoquanquanlysApi apiCoQuanQuanLy2 = new CoquanquanlysApi();
			apiCoQuanQuanLy2.setApiClient(defaultClient);
	        try {
	        	List<CoQuanQuanLy> listCQQL = apiCoQuanQuanLy2.coquanquanlysCapTrenCapTrenGet("00001");
	        	for (CoQuanQuanLy cqql : listCQQL) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + cqql.getId());
	        		System.out.println("ma: " + cqql.getMa());
	        		System.out.println("ten: " + cqql.getTen());
	        		System.out.println("diaChi: " + cqql.getDiaChi());
	        		System.out.println("dienThoai: " + cqql.getDienThoai());
	        		System.out.println("email: " + cqql.getEmail());
	        		System.out.println("fax: " + cqql.getFax());
	        		System.out.println("website: " + cqql.getWebsite());
	        		System.out.println("cap: " + cqql.getCap());
	        		System.out.println("capTren: " + cqql.getCapTren());
	        		System.out.println("donViHanhChinh: " + cqql.getDonViHanhChinh());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 8:
			// Lấy cơ quan quản lý theo mã cơ quan quản lý
			CoquanquanlysApi apiCoQuanQuanLy3 = new CoquanquanlysApi();
			apiCoQuanQuanLy3.setApiClient(defaultClient);
	        try {
	        	CoQuanQuanLy cqql = apiCoQuanQuanLy3.coquanquanlysMaGet("00001");
	        	if (cqql != null) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + cqql.getId());
	        		System.out.println("ma: " + cqql.getMa());
	        		System.out.println("ten: " + cqql.getTen());
	        		System.out.println("diaChi: " + cqql.getDiaChi());
	        		System.out.println("dienThoai: " + cqql.getDienThoai());
	        		System.out.println("email: " + cqql.getEmail());
	        		System.out.println("fax: " + cqql.getFax());
	        		System.out.println("website: " + cqql.getWebsite());
	        		System.out.println("cap: " + cqql.getCap());
	        		System.out.println("capTren: " + cqql.getCapTren());
	        		System.out.println("donViHanhChinh: " + cqql.getDonViHanhChinh());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 9:
			// Lấy danh sách dân tộc
			DantocsApi apiDanToc = new DantocsApi();
			apiDanToc.setApiClient(defaultClient);
	        try {
	        	List<DanToc> listDanToc = apiDanToc.dantocsGet();
	        	for (DanToc danToc : listDanToc) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + danToc.getId());
	        		System.out.println("maDanToc: " + danToc.getMaDanToc());
	        		System.out.println("tenGoi: " + danToc.getTenGoi());
	        		System.out.println("tenKhac: " + danToc.getTenKhac());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 10:
			// Lấy dân tộc theo ID
			DantocsApi apiDanToc2 = new DantocsApi();
			apiDanToc2.setApiClient(defaultClient);
	        try {
	        	DanToc danToc = apiDanToc2.dantocsIdGet("1");
	        	if (danToc != null) {
	        		System.out.println("id: " + danToc.getId());
	        		System.out.println("maDanToc: " + danToc.getMaDanToc());
	        		System.out.println("tenGoi: " + danToc.getTenGoi());
	        		System.out.println("tenKhac: " + danToc.getTenKhac());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 11:
			// Lấy danh sách tôn giáo
			TongiaosApi apiTonGiao = new TongiaosApi();
			apiTonGiao.setApiClient(defaultClient);
	        try {
	        	List<TonGiao> listTonGiao = apiTonGiao.tongiaosGet();
	        	for (TonGiao tonGiao : listTonGiao) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + tonGiao.getId());
	        		System.out.println("maTonGiao: " + tonGiao.getMaTonGiao());
	        		System.out.println("tenGoi: " + tonGiao.getTenGoi());
	        		System.out.println("tenKhac: " + tonGiao.getTenKhac());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 12:
			// Lấy tôn giáo theo ID
			TongiaosApi apiTonGiao2 = new TongiaosApi();
			apiTonGiao2.setApiClient(defaultClient);
	        try {
	        	TonGiao tonGiao = apiTonGiao2.tongiaosIdGet(1);
	        	if (tonGiao != null) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + tonGiao.getId());
	        		System.out.println("maTonGiao: " + tonGiao.getMaTonGiao());
	        		System.out.println("tenGoi: " + tonGiao.getTenGoi());
	        		System.out.println("tenKhac: " + tonGiao.getTenKhac());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 13:
			// Lấy danh sách loại đơn vị đo lường
			LoaidonvidoluongsApi apiLoaiDonViDoLuong = new LoaidonvidoluongsApi();
			apiLoaiDonViDoLuong.setApiClient(defaultClient);
	        try {
	        	List<LoaiDonViDoLuong> listLoaiDonViDoLuong = apiLoaiDonViDoLuong.loaidonvidoluongsGet();
	        	for (LoaiDonViDoLuong loai : listLoaiDonViDoLuong) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + loai.getId());
	        		System.out.println("ten: " + loai.getTen());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 14:
			// Lấy loại đơn vị đo lường theo ID
			LoaidonvidoluongsApi apiLoaiDonViDoLuong2 = new LoaidonvidoluongsApi();
			apiLoaiDonViDoLuong2.setApiClient(defaultClient);
	        try {
	        	LoaiDonViDoLuong loai = apiLoaiDonViDoLuong2.loaidonvidoluongsIdGet(1);
	        	if (loai != null) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + loai.getId());
	        		System.out.println("ten: " + loai.getTen());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 15:
			// Lấy danh sách đơn vị đo lường
			DonvidoluongsApi apiDonViDoLuong = new DonvidoluongsApi();
			apiDonViDoLuong.setApiClient(defaultClient);
	        try {
	        	List<DonViDoLuong> listDonViDoLuong = apiDonViDoLuong.donvidoluongsGet();
	        	for (DonViDoLuong donViDoLuong : listDonViDoLuong) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + donViDoLuong.getId());
	        		System.out.println("daiLuong: " + donViDoLuong.getDaiLuong());
	        		System.out.println("kyHieu: " + donViDoLuong.getKyHieu());
	        		System.out.println("kyHieuSI: " + donViDoLuong.getKyHieuSI());
	        		System.out.println("tenDonVi: " + donViDoLuong.getTenDonVi());
	        		System.out.println("tenTA: " + donViDoLuong.getTenTA());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		case 16:
			// Lấy đơn vị đo lường theo ID
			DonvidoluongsApi apiDonViDoLuong2 = new DonvidoluongsApi();
			apiDonViDoLuong2.setApiClient(defaultClient);
	        try {
	        	DonViDoLuong donViDoLuong = apiDonViDoLuong2.donvidoluongsIdGet(1);
	        	if (donViDoLuong != null) {
	        		System.out.println("---------------------");
	        		System.out.println("id: " + donViDoLuong.getId());
	        		System.out.println("daiLuong: " + donViDoLuong.getDaiLuong());
	        		System.out.println("kyHieu: " + donViDoLuong.getKyHieu());
	        		System.out.println("kyHieuSI: " + donViDoLuong.getKyHieuSI());
	        		System.out.println("tenDonVi: " + donViDoLuong.getTenDonVi());
	        		System.out.println("tenTA: " + donViDoLuong.getTenTA());
	        	}
	        } catch (ApiException e) {
	            e.printStackTrace();
	        }
			break;
		default:
			break;
		}
	}
}
