package com.google.zxing;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class MultiFormatWriterTest {
	
	@Test
	public void encode() throws Exception {
//		String content = "http://www.nbzhwj.cn/m/c?c=41954568160627067323@2016-07-01";
		String content = "http://weixin.qq.com/q/Vjq0KePmfYcE4D9upxKe";
		String filepath = "C://Users//Administrator//Desktop//test5.jpg";
		int width = 100;
		int height = 100;
		Map<EncodeHintType, Object> encodeHints = new HashMap<EncodeHintType, Object>();
		encodeHints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,
				encodeHints);
		Path path = FileSystems.getDefault().getPath(filepath);
		MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
	}
	
	@Test
	public void decode() throws Exception {
//		String filepath = "C://Users//Administrator//Desktop//55555.jpg";
		String filepath = "C://Users//Administrator//Desktop//test5555.jpg";
		BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filepath));
//		BufferedImage bufferedImage = ImageIO.read(new URL("http://wap.xbcare.com.cn/static/img/HIOVOo4Wj4iIXe0i54Wmtb-J87F9lzOF5BYz7GfrKCNHE2KMv1Co9wN9PbUz6Hw5.jpg"));
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		Binarizer binarizer = new HybridBinarizer(source);
		BinaryBitmap bitmap = new BinaryBitmap(binarizer);
		HashMap<DecodeHintType, Object> decodeHints = new HashMap<DecodeHintType, Object>();
		decodeHints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
		Result result = null;
		try {
			result = new MultiFormatReader().decode(bitmap, decodeHints);
		} catch (Exception e) {
			e.printStackTrace();
			// com.google.zxing.NotFoundException
		}
		if(null != result){
			System.out.println(result.getText());
		}else{
			System.out.println("解析失败！");
		}
	}
	
	public static Map<Integer, String> qrcodeMap = Maps.newTreeMap();
	static{
		qrcodeMap.put(6132, "http://wap.xbcare.com.cn/static/img/HIOVOo4Wj4iIXe0i54Wmtb-J87F9lzOF5BYz7GfrKCNHE2KMv1Co9wN9PbUz6Hw5.jpg");
		qrcodeMap.put(6306, "http://wap.xbcare.com.cn/static/img/iWeXL5ZKKEKNfvlj3cvUtnZd9y1LuPGwf3wr1jQ-2FJTDOaIOuTrEyv7p_AnAoW1.jpg");
		qrcodeMap.put(578, 	"http://wap.xbcare.com.cn/static/img/uYOkzvuDqlT01eBiZa2c3DS3W_EU0S1xGO9YMdOdcKizzKj6-xTB4db3QMbsYjMr.jpg");
		qrcodeMap.put(6307, "http://wap.xbcare.com.cn/static/img/aVTd7hfQlPgu1zaqf-rkSvtO6yzU8sehdBTLQRlMLwZLq3Bvnu51lWisNnJrRhtH.jpg");
		qrcodeMap.put(6152, "http://wap.xbcare.com.cn/static/img/XLRoKhl2yUfmmMoJ7i4KR9FLrWwfKFxOWS46Ije0laXxeLFCBHz1cRUzLVb4wa2P.jpg");
		qrcodeMap.put(6190, "http://wap.xbcare.com.cn/static/img/Xg9VLe7hkt6moJdDafrCAm912VzqhnAUjCMyUnrUw3foilQ31tVvKlMCmFEnZbIn.jpg");
		qrcodeMap.put(574, 	"http://wap.xbcare.com.cn/static/img/iUYqtQeQX2SExdg3wU09W5S96zkSoubmMZ2jsSUz-pb73oVS4SkIGKlgGVfRbpJQ.jpg");
		qrcodeMap.put(575, 	"http://wap.xbcare.com.cn/static/img/Gpz7uS1w1kfl-i0Bg46bEvzUjCBRUqSzvmq6MqLvAGCtBSXdzmJiB-2JwSzSSUH3.jpg");
		qrcodeMap.put(308, 	"http://wap.xbcare.com.cn/static/img/9PsU9FrfWDuMzx7w1eWVw1kGL9_ZvYfTx0tYCdY8G3eEnaLz0Sn5LnxYuy7Tagfv.jpg");
		qrcodeMap.put(837, 	"http://wap.xbcare.com.cn/static/img/IV8VxVNwxwy2RICUHIoAT5kSUiTS6zYkYXuxyjY0I9EKGHjumTA0-noalbERALbP.jpg");
		qrcodeMap.put(377, 	"http://wap.xbcare.com.cn/static/img/李国友11.jpg");
		qrcodeMap.put(852, 	"http://wap.xbcare.com.cn/static/img/kSXB8ZurMiMtYg_4uRwyyQ_i9yKIT2I4Ke6G_LZpkbe4C1G2bnGx8AgKq4b_dIBB.jpg");
		qrcodeMap.put(1778, "http://wap.xbcare.com.cn/static/img/nXgReYvz_Rr-iYnO6MUE7UOWsf567kGFF6KOqFdS9aZHJHjErT7ehbwVurIepkL5.jpg");
		qrcodeMap.put(569, 	"http://wap.xbcare.com.cn/static/img/O5qb_69vLkMUOT3iwkoLx7mwh5s-G_jdGcwnST7oXUHmENDDC4V3GWyh-SH9EtC4.jpg");
		qrcodeMap.put(855, 	"http://wap.xbcare.com.cn/static/img/1pvZaZ_gdGXlEqngzftMNU7esBR5g7yBEl_M8iNDc9q0pUjSj7exO1kM19yHSOfw.jpg");
		qrcodeMap.put(1768, "http://wap.xbcare.com.cn/static/img/nky4KvQDjKXrXhyjHNijRPn3wf-eBBJpcxtpLhjcW4XegJ6tG7y-bKnpMXZxJPRj.jpg");
		qrcodeMap.put(322, 	"http://wap.xbcare.com.cn/static/img/ZkSW_CmYQ7U4LXGNm8JUTBSPxn6AmtraTvzbWJ1PZrkx5urJNmtbC2vGZhNi-eEJ.jpg");
		qrcodeMap.put(1480, "http://wap.xbcare.com.cn/static/img/6AM6V-j2IqkG6k_V9uPWM_eYeyHkU5fIFJD6HYYugDKV1KCHkcCT_BXagcYwp_gQ.jpg");
		qrcodeMap.put(6787, "http://wap.xbcare.com.cn/static/img/jkz.png");
		qrcodeMap.put(1205, "http://wap.xbcare.com.cn/static/img/fYUL5goHJRmHSkB8vIkiFEVhN6zTztuIQ-AK5dTqcJDQ3vMdTDl63zUW4GJb1qXf.jpg");
		qrcodeMap.put(1802, "http://wap.xbcare.com.cn/static/img/GxbPrgNZmkVpRgq0_Za7SKvJoEL2EJVWhHaxxHSjKjEM357XgD0ImpvnO5auE_Yh.jpg");
		qrcodeMap.put(1217, "http://wap.xbcare.com.cn/static/img/GKz12yBgJGvUo2eVqT4AiYveqI9ePrwWM1CiBzut9NxPn1JnIYd7ohokZaAau8iV.jpg");
		qrcodeMap.put(1210, "http://wap.xbcare.com.cn/static/img/SqunLKvbTAVIgQCTD3Ix41-n3OpaX0pD7ps-Kq-1iVGWKGI7N00j8N4_QLyfXUzH.jpg");
		qrcodeMap.put(6903, "http://wap.xbcare.com.cn/static/img/T2t_T2QSBvG-WOsIHUhM1ysytGIDKWBn2gzEBX2c1024NwFaXZRneps8FLcIwLjT.jpg");
		qrcodeMap.put(394, 	"http://wap.xbcare.com.cn/static/img/yBr5mXou7gCu-wbOBHXuhpPQoYvX4JT4LshTPwm9njGND9pDPnhYq-e6qqNP9o4l.jpg");
		qrcodeMap.put(2215, "http://wap.xbcare.com.cn/static/img/Ji2BAuDfbyrLyiaontX_bOQjKAbvry0qY1YMOU7Sg4yXcFAiAnAoyajyl6GhU3Eq.jpg");
		qrcodeMap.put(528, 	"http://wap.xbcare.com.cn/static/img/Da81TsRcbkHxRZGejk0CXPICWmeOscDNhad_xkznlikpCNwINKfu9wmEqO8eXDbI.jpg");
		qrcodeMap.put(1774, "http://wap.xbcare.com.cn/static/img/B64ALykutQbZznIrhzolylv8XXZ3L2pRGprU70AcHbeJTI4OAFqdLODh2J1TzUJk.jpg");
		qrcodeMap.put(567, 	"http://wap.xbcare.com.cn/static/img/HuYlZ7fSbn7bweSij61Q6i_vvaFY1oL12JnC1Tnem2GUdKrEf17p2ZbzVv2XhB-U.jpg");
		qrcodeMap.put(6283, "http://wap.xbcare.com.cn/static/img/6TOsHO4AfGlTLc4YVz3T6ZCKcBwh3Y_B0FyzNwZBOjA29yRUYNvmj8RId6MPnYFS.jpg");
		qrcodeMap.put(1788, "http://wap.xbcare.com.cn/static/img/rhTYks92qodbPgqzfWmeb16a_AO35DcW7dqegkYpFRwhDfASbs-HM_1gtK0IonE_.jpg");
		qrcodeMap.put(864, 	"http://wap.xbcare.com.cn/static/img/ObitUMfcwbg6eGJUbNQaLquDEZJWTCTW0VTXauZKSZxWzFFDr4VNujRoQT6aVaYY.jpg");
		qrcodeMap.put(360, 	"http://wap.xbcare.com.cn/static/img/lUzkrc9m4rOZprNh5maYnoV18QON21xJBTblxkz3IhYwHwQf4fprEQizhL6T1fAC.jpg");
		qrcodeMap.put(2315, "http://wap.xbcare.com.cn/static/img/T7jYjxZB9bf-V0TiXu44wCXrlio_nkcgYOKdehA9rqbIKjXIsKLVoj2ALbqzi8Df.jpg");
		qrcodeMap.put(570, 	"http://wap.xbcare.com.cn/static/img/t5bU_38Q-KxlDYwOHPGNJKCyWMoAGEromMRkRLrbWNwB40alVnbErsR1aLhPOuYS.jpg");
		qrcodeMap.put(1221, "http://wap.xbcare.com.cn/static/img/LZTUCrrq8h2BAl0ifTHbofqcwd54-DTL2OwLPFoeJiglW44Ogc-n0U8XtSuxEVaE.jpg");
		qrcodeMap.put(1782, "http://wap.xbcare.com.cn/static/img/WGX12Ml5sQKNMi2zOcOJ3foEqSOTyjWWs4999wHjdEUGbg1rjKUQCEAvmWtdJJno.jpg");
		qrcodeMap.put(296, 	"http://wap.xbcare.com.cn/static/img/MAtD_tEY_OLCtHJiDYiWjChGUg5ykVTErGXyiHKaccUEe2fBPYhidCrhYPgHyXNx.jpg");
		qrcodeMap.put(1772, "http://wap.xbcare.com.cn/static/img/FRIi_rYP8CWZiQOG_uPcWhRz7x4EFdswxykk4cjQL1JbKLpDU-2MSZkVGYlL27JU.jpg");
		qrcodeMap.put(286, 	"http://wap.xbcare.com.cn/static/img/3RpissCLDoPp3nbdYl3UOHZQtlyzLZHe0zhOkDPpB_dTDDXOfHYWCkV5uwt6yaPf.jpg");
		qrcodeMap.put(561, 	"http://wap.xbcare.com.cn/static/img/FNpcXpZ-WdUYIkpcItpn6OCyNk4FE2b8Rdh5is7bRmTk3VFPZRsbKNcNyj_CBF-t.jpg");
		qrcodeMap.put(516, 	"http://wap.xbcare.com.cn/static/img/r5qSHP5Ds8H1UvWgsbk9jrhauHej6CpjF4pHMrxZKMwYkImtRNQqLHDtQXkJ-tWe.jpg");
		qrcodeMap.put(582, 	"http://wap.xbcare.com.cn/static/img/L_zaE03sa0fvR5zK9SdYVhaXWdGAcXhRI0ctFR4wzKBfUwsmJHAQ9fIqYi8vXBhW.jpg");
		qrcodeMap.put(6925, "http://wap.xbcare.com.cn/static/img/ECfuKRp38c5Wt7M0yjxx7fMop4fHvbp82F75I6CZjtglC16ACRHeJTi2Cn5Ba3zD.jpg");
		qrcodeMap.put(2478, "http://wap.xbcare.com.cn/static/img/jdW_S5TaiH8nfY6iMD53ZnEsNlJBOO1bV_SVfSxWYikwVxC6g05eEVU8vMqQSGRI.jpg");
		qrcodeMap.put(6928, "http://wap.xbcare.com.cn/static/img/r7kRwaNiKGbjYPKcxA6cwEMApMBP6JvyKkh4-jedQgYxc8eZVda_9fBZvtLtcQmk.jpg");
		qrcodeMap.put(6927, "http://wap.xbcare.com.cn/static/img/Y03EShUpR2JmW2XPF_WJs91OhuoYKtmMhHBSFKjudbnGVOw-EEGoGiQwiE7JjAK9.jpg");
		qrcodeMap.put(504, 	"http://wap.xbcare.com.cn/static/img/qTGlV_DsscT8MnoUOleXyq24ejKIQUXQA9RA4v1hjJ7j86ALeMXakglweGZ1bLUD.jpg");
		qrcodeMap.put(1199, "http://wap.xbcare.com.cn/static/img/2sHMP1Aprc8lHZZHbDOw_PpXDuRlgSmB1ABg22PsNoAWJqH94PE6D3Do4BN57MGt.jpg");
		qrcodeMap.put(6929, "http://wap.xbcare.com.cn/static/img/DVALtyLSRdgRAoLxv-xa_VG1ad5wsMYzuYRiJpIVqD6-Rb0QKsHnb8YtdM5E7R0V.jpg");
		qrcodeMap.put(1779, "http://wap.xbcare.com.cn/static/img/rhTYks92qodbPgqzfWmeb32CrUA02XdP3aTlbUFxzGlhI5bL8feC0Hxl0CZz4S0B.jpg");
		qrcodeMap.put(488, 	"http://wap.xbcare.com.cn/static/img/fT5HfToux_rF7DpCjkThx-_OMIt7GR56Q__iC7PhEJNGIG-EhQzIgRcP_qVNsFMy.jpg");
		qrcodeMap.put(290, 	"http://wap.xbcare.com.cn/static/img/5X3z5Q2Ehw4ikwyrRoK8DHFaUZM32oCJ__4jOFbQunvUqTcLqKKYv9Q598Ban7Kz.jpg");
		qrcodeMap.put(6173, "http://wap.xbcare.com.cn/static/img/opdmI03c-FGgzTSzp5QmkNfwWOvsLzDlkACqPoYtIQcXHQFSv0SzMcfwD8e0U65_.jpg");
		qrcodeMap.put(320, 	"http://wap.xbcare.com.cn/static/img/RI6Hoi9R-OEKkkGWxspBek_CWRND2rxozNvsa73pev9CFUNLOcfqZeJQ8DpCmgnZ.jpg");
		qrcodeMap.put(329, 	"http://wap.xbcare.com.cn/static/img/jpgm1chhy8bIvFU6ugFG1XG00T22viypDsWQ3Poxws-V6f10ZkYJ0MssJFcENWmq.jpg");
		qrcodeMap.put(6136, "http://wap.xbcare.com.cn/static/img/XD4wQA2lhk7IF_cCfoKqlh8kW_0gErp6x8ayhwsUXl8JZorIgmaBqIntd6_e9KnJ.jpg");
		qrcodeMap.put(529, 	"http://wap.xbcare.com.cn/static/img/EEfMnlBrB4AOn-bXqmg9uGRSADJuEbH-c9J3vMZb0n8EKafcAT60VoSFe937pcuo.jpg");
		qrcodeMap.put(1786, "http://wap.xbcare.com.cn/static/img/GdngKSLZmBGwrWF29ASpJyUnt6FW5cY6y1mU7qR1lwfjG5g0rXC5U6K1utYB2OPl.jpg");
		qrcodeMap.put(565, 	"http://wap.xbcare.com.cn/static/img/64sa_PHifNgc2_Ke8N9T05m38S6PsCgHy702gU1dmrT9f9CJ-TTNRKAjbeNjgk4F.jpg");
		qrcodeMap.put(2321, "http://wap.xbcare.com.cn/static/img/l2mbw2nhYubKCXHfiMWcxS7RoGciMLSIXbTXS_NJnmzo0Vf6gVgAxw0PyNUpo1Vh.jpg");
		qrcodeMap.put(591, 	"http://wap.xbcare.com.cn/static/img/6fqCVsXpqWK0GZqYRgNiXZxFyW3U5xgv4hmVNAGGUt2xqxE8AqwgN2YQ9Wne28Cd.jpg");
		qrcodeMap.put(510, 	"http://wap.xbcare.com.cn/static/img/vXi9mjgT1SaJv_CGaV-6iO4yKhcfNApa85E1TRebQYCTP2PEACKN95o4iMPGGa5R.jpg");
		qrcodeMap.put(353, 	"http://wap.xbcare.com.cn/static/img/xihS0n6ETJVe1Udf7MpLZxHjuLPLrAT2KqI_Wu5w8qbbegt5EP9l6KImLtpYR3Tj.jpg");
		qrcodeMap.put(854, 	"http://wap.xbcare.com.cn/static/img/O16ky2wkVQXzJjyA2_1x6qvMMNyV0gipmgP3Aj4bog_krcr9aFuWASXe45a1tM2S.jpg");
		qrcodeMap.put(2317, "http://wap.xbcare.com.cn/static/img/ExYP5DvL6IfRoqZV8CtSSzNPEc4MIRIEXc7-lFq4ICLlK_YYeRlekZRKvmz1NXsN.jpg");
		qrcodeMap.put(596, 	"http://wap.xbcare.com.cn/static/img/DR_pYOZJK-98jrrOdpCv50jvf4sgaVEaXvjzioKYzJjdJgMzbI5HkAx9jAOR2dJs.jpg");
		qrcodeMap.put(2336, "http://wap.xbcare.com.cn/static/img/whPkEPb7Su__qKIq953U-ZF8MgDmUR7fFkwzg_Co_opYvjMhQy-FWOo_RZC8yH0U.jpg");
		qrcodeMap.put(1219, "http://wap.xbcare.com.cn/static/img/1-5zW2XSnIKdamrpViwrxakgH_AohDqUnGUzeVmSXdHzeEXdIMls31b7X99lPHLV.jpg");
		qrcodeMap.put(484, 	"http://wap.xbcare.com.cn/static/img/-geiSLwjCFL0lIK5LNXr4lLdyzAMG2BGpJLUzE0G1vbx00uWCi47BEYDTpK429tS.jpg");
		qrcodeMap.put(6156, "http://wap.xbcare.com.cn/static/img/gYGXajuQauRdVvFj-U2-qU5lx370MW3ok-Ca6NEOpd8r_TrWiv3Ig-KXyto8QFoc.jpg");
		qrcodeMap.put(1796, "http://wap.xbcare.com.cn/static/img/GryBbdCKXWnRaoI45Te4wWDG66BO-G0ZkQF8K_E7w1cmHtBPnd-OAtsAZ84ZwCRD.jpg");
		qrcodeMap.put(590, 	"http://wap.xbcare.com.cn/static/img/5l_FAUDjophziHOEWryC_YsYNG-Q1dv6r6i8Dp9MsW4t23SoLPjr94bCYYg2XSL8.jpg");
		qrcodeMap.put(6142, "http://wap.xbcare.com.cn/static/img/HdwVpf1tGWdiRr6pvswWaQz8y-aDdK_9WIyYbULf82GcvwnHutycmW7djBuLKJyy.jpg");
		qrcodeMap.put(364, 	"http://wap.xbcare.com.cn/static/img/cPUKcSJnxdKRywfBNpwC_5X1-TIeiOc1oOH0EucHTHmoSk0k7ZBRrBl47EmerRUi.jpg");
		qrcodeMap.put(982, 	"http://wap.xbcare.com.cn/static/img/boyWeiN7vtXv9sNtk4RdKNSAFuw25GwlWhPkd-KMQxQI6eI2H-D0RHgJdbJP8ask.jpg");
		qrcodeMap.put(6669, "http://wap.xbcare.com.cn/static/img/xhGA781UJw6skI3QSNC_A1YOoeoT01qqk5hDHDvIDjRVzxQh1SwWihN9wpa33o-I.jpg");
		qrcodeMap.put(579, 	"http://wap.xbcare.com.cn/static/img/xmSJ4NI2cEz_2yX00MXxoToUrxkcMCQLvYHRSwojdIhCYzsOjmGA_ZznEIG2zn_b.jpg");
		qrcodeMap.put(1790, "http://wap.xbcare.com.cn/static/img/hjyVNj6WOUnwGbcmXCqGxUwjsmaovjm-5sF5bikXxqjJXpTIY7BPZ-7w0uBUvezu.jpg");
		qrcodeMap.put(2484, "http://wap.xbcare.com.cn/static/img/IVTIb6zecSNTFV3wOubtVEEwownQ4vhpihvuFU_nhWc43_gcf4ULWELGZ3jZLIeB.jpg");
		qrcodeMap.put(334, 	"http://wap.xbcare.com.cn/static/img/WVcl9LegKRK1RBOtNZy2k_CX0gJSiryD2UQgZXQ6lQ7fqq5CIywNw4Gr5i9aFICI.jpg");
		qrcodeMap.put(1789, "http://wap.xbcare.com.cn/static/img/CidyZb9tmVoIkMV_4fxMlWgdN2YE5JucyrCZKwaDOLsPL07COM0uwmebqBK1F5l_.jpg");
		qrcodeMap.put(6672, "http://wap.xbcare.com.cn/static/img/XbHtSv9yM6YO7jEtXJnNnFylkRMvDCzSVq57gRWg8tUxHRaBJ4EjVhmlDsTsrkZZ.jpg");
		qrcodeMap.put(333, 	"http://wap.xbcare.com.cn/static/img/xUaykZIvcBbI1UniZVUkdJVSFEnUSwkiVUcAoN46uP8gCt_MOZ6xr9Wb51CxWmFM.jpg");
		qrcodeMap.put(370, 	"http://wap.xbcare.com.cn/static/img/y78g7X_EX1MGGamYP_Ng-bom3011SSkMu4ppdNhSoBSG1CniyS-bIiJrMi_nIufL.jpg");
		qrcodeMap.put(2334, "http://wap.xbcare.com.cn/static/img/TN8BDXIPV5eAyTpL-815lmoalTYypNS97-9YHe4SR-ZxbzF0aV9rISnaQbiZYlL2.jpg");
		qrcodeMap.put(1197, "http://wap.xbcare.com.cn/static/img/sqUZ2bnMG0y9MP0J9rCNGEARiiJkjC2mDmxoAKSgxev3AYvzcMyCwU4YQXa-B3CK.jpg");
		qrcodeMap.put(6164, "http://wap.xbcare.com.cn/static/img/vUahIVvmrj-EXoeVfzJKJkJbld_epyL2c8cG2PU8MU4RxqFmgQ7skoWx6mi2KFaW.jpg");
		qrcodeMap.put(845, 	"http://wap.xbcare.com.cn/static/img/hrU3u9y1dBNpvRxfYuz55B4RRHQpVxL3ivKduF4i1znL7i43B3zRx6cE14hqyJps.jpg");
		qrcodeMap.put(485, 	"http://wap.xbcare.com.cn/static/img/43rzwIdYRF0lXFPaKk7MgXghST--gnEGCGywnHOKWzsQ6gbJUe76V4saMvMqD2I0.jpg");
		qrcodeMap.put(6172, "http://wap.xbcare.com.cn/static/img/1Vihi5KlFmlj16ToYTzZ3ltIttvQpGz5-G6VkqgMsamIVqBiKMVGB-e_Eitw28bn.jpg");
		qrcodeMap.put(587, 	"http://wap.xbcare.com.cn/static/img/FiMDop1EDDnYPo12qBhULEe3l7ijLasaCDwW8bvCWmM51vGyd_D8LdCywx87TJdf.jpg");
		qrcodeMap.put(6302, "http://wap.xbcare.com.cn/static/img/_yz5WFL412gpKYDAGHQTuIqX2wmCB8lOxtJjXGR8oL53YAWFsFgwk62C1nzw7E6m.jpg");
		qrcodeMap.put(335, 	"http://wap.xbcare.com.cn/static/img/AB_QDw6d-NeSZdRcdhc8Fpzv4yufkreN8R_N7dBK42OriwY6O8pM2nT15PafO-ur.jpg");
		qrcodeMap.put(6420, "http://wap.xbcare.com.cn/static/img/0jzwIVUSkWLkjcIzhnWeDbnZi2t_JehlPTWnLiz3sRAbgj6SZIllWleTm2Xh-oRr.jpg");
		qrcodeMap.put(6179, "http://wap.xbcare.com.cn/static/img/n-qPJ44a86e7f3kAH0wdcceDTI2NybRtaSlB4Sp5QuUJyfKYTU3yqmp2Q9Ug9osJ.jpg");
		qrcodeMap.put(6399, "http://wap.xbcare.com.cn/static/img/E9ddwLDM1YmNStSzN02x12VUum3vsEq_0MdBtKXu_TkQHz2DSftIoa4-3jLceMuY.jpg");
		qrcodeMap.put(294, 	"http://wap.xbcare.com.cn/static/img/oSL1EUVTW3QIiozmDRGJY635GQE3CsEXJefDF3iIY1O_glpEHvJn8qM1f_A2Qb4E.jpg");
		qrcodeMap.put(847, 	"http://wap.xbcare.com.cn/static/img/OGWGFWPwB8UASO1pJ5E0AWVLdDQMXoV7pc07otBsTzQEWZHlmbo6Rojduo7cJPmP.jpg");
		qrcodeMap.put(6144, "http://wap.xbcare.com.cn/static/img/rXZWL7-k9C8b0TtjNjLLoag_yBHrUOEheLfKHWQDnrBOdwxPPHSS3T5P4ynKlsJw.jpg");
		qrcodeMap.put(1192, "http://wap.xbcare.com.cn/static/img/XZjtVYbylAPrWKs4fcdmtUjX8tAvascEwYOt5THm0yszvfqxY3vmLuOvKZl8a-80.jpg");
		qrcodeMap.put(853, 	"http://wap.xbcare.com.cn/static/img/1zOhY6n6c0-SnHcO2T5ViCYLB1bt_5goNo0SUrCopdNJOBFQn-4PBq0G0Jj5agjo.jpg");
		qrcodeMap.put(1195, "http://wap.xbcare.com.cn/static/img/Z1frH8v6VnIEEJ3MOzQldpGAwmohOx_qB38_BVmPjr6zncs2sohvf-N_GZtBSV6i.jpg");
		qrcodeMap.put(1800, "http://wap.xbcare.com.cn/static/img/mZs2GsopVyXknn94ACpYoqRZ2F3PIzRntsNGmARsfpoJ1cOnbXG3O-oCllilTtDZ.jpg");
		qrcodeMap.put(456, 	"http://wap.xbcare.com.cn/static/img/RTg-A2oIRXpKGN0D430Es7DSwqcsz4SlneNR3UFKGgiblrFCmATuRsB7VKa0sEHj.jpg");
		qrcodeMap.put(598, 	"http://wap.xbcare.com.cn/static/img/9yaAujcTkDhtqPA2dU5PmblwntQhdpaQgh7byWJ-qR_YlizBKLjhrSg1mK4GsC1P.jpg");
		qrcodeMap.put(842, 	"http://wap.xbcare.com.cn/static/img/b3M5nhfUUotg4744PpQM17n5xpNY0ib_RH1AsuBwTEtqYkKZEnlPSufFEtqaA6Ka.jpg");
		qrcodeMap.put(571, 	"http://wap.xbcare.com.cn/static/img/r7ZJYeOE1UzAKhbf-7eG-oXH9iKm5uVTrurNBDIoGdF6yjbNdYzzjONKdp90eV-N.jpg");
		qrcodeMap.put(478, 	"http://wap.xbcare.com.cn/static/img/ooCyD8ZZRsPZi2RpVz154-Mx39zhRYJReIX2wm2hY_rlh2_PxZAvd2oKlXfV1VQF.jpg");
		qrcodeMap.put(2326, "http://wap.xbcare.com.cn/static/img/13q_hrjD1OGKG7qfH6CMP12Ot6R5nK70IIkH78fryMcBybGDYAavQnvNfpLv3Dmr.jpg");
		qrcodeMap.put(6182, "http://wap.xbcare.com.cn/static/img/hz6gg2nKNDveet9j3F3Vz2g6i2x58hJsd9Rdl2pIzCI5wfM1FG-u63r3cHA7EWqv.jpg");
		qrcodeMap.put(1186, "http://wap.xbcare.com.cn/static/img/ipSXhM-AL2k_G5IAqE_VsqirAKZHszgv9KYv3Yh253Dy0RraqlPfGirpZega0ig3.jpg");
		qrcodeMap.put(457, 	"http://wap.xbcare.com.cn/static/img/EgKjDeQDyWwmREEXfsld48sUr18y-QHOjwYzK_x0hNCPQ7S02_auaa33zkZEehnu.jpg");
		qrcodeMap.put(851, 	"http://wap.xbcare.com.cn/static/img/r_uXGVtEQebcPPzqBX4Fkg7PoChabI3hDzH7qn0x8T97Bs7A_iKO6ZNLPW2MQaZV.jpg");
		qrcodeMap.put(2488, "http://wap.xbcare.com.cn/static/img/zNSv4XEtNuH0M-T1-oo2FOvUauDTM7YeUB1NIQ-n75rOTef72t5VzcvZtpb-ObwB.jpg");
		qrcodeMap.put(6280, "http://wap.xbcare.com.cn/static/img/53-1zTTVTyirx-B_nsG6x7gmQrjeTw7hZMmm-S7EJc8b6z0z48FeBs1Setp94peH.jpg");
		qrcodeMap.put(2343, "http://wap.xbcare.com.cn/static/img/G7tH0REc8OGvi0pBgdG_zABBA-74vjjVXX8w2zAsbCpmOIpKI78IdtqzCMh0NAoB.jpg");
		qrcodeMap.put(6151, "http://wap.xbcare.com.cn/static/img/5C8BVbnwhaP9-q22xPWepHn4XkULMCKlnQv-FR9Qy_R-8QV4H4Nb48y3yfIk9PAL.jpg");
		qrcodeMap.put(6294, "http://wap.xbcare.com.cn/static/img/TiBPHacgIXOATuyckffSx1gzxt9Ucx8ccE0BFVgnO3rpFNWC82LJszniZgBULFp_.jpg");
		qrcodeMap.put(471, 	"http://wap.xbcare.com.cn/static/img/Q3ajWT_-jwoiwiC8BwtiDXBQYv-Ah7kYqgPzLURmmMU69ImJNHUMN-Y1GU-5NQyI.jpg");
		qrcodeMap.put(6299, "http://wap.xbcare.com.cn/static/img/pUmDYvchJJwjjVNwNPSX5K7b0EpDOFM36vVkPErQakG1mlKrO13n3dQgzJX_PkfH.jpg");
		qrcodeMap.put(6953, "http://wap.xbcare.com.cn/static/img/j0fMwVsPyQ_O3w-CrSIo84qsgCR4Wi4kl4iAyyoj7pDY4VlbEoIFGC2Qy1VZd_pW.jpg");
		qrcodeMap.put(6951, "http://wap.xbcare.com.cn/static/img/C7pTEaPHUJz_ajiHRR4eit3XXFZiO4EB6hdJw9kVrw5M6uyJTc6guGTzeDmFrNOM.jpg");
		qrcodeMap.put(6955, "http://wap.xbcare.com.cn/static/img/gw6yKq_eB9AStlJOZuA8enDJQHEWogc-HUMm2H2BilQ1KYhOcjUYOuxD6hVRCjx9.jpg");
		qrcodeMap.put(6932, "http://wap.xbcare.com.cn/static/img/9bj3K1nKJzal1pa-0FTedofi90aEoOOe_s1Wmw_pp61dt1yylmt5EXsP9sOgWYB4.jpg");
		qrcodeMap.put(6954, "http://wap.xbcare.com.cn/static/img/3jPJa6bhn8k2BdWoUMZCJ71LrlDQ0_wW93Dnyb_7GYkuGoMUp2Fb3YCttIol_eh-.jpg");
		qrcodeMap.put(6950, "http://wap.xbcare.com.cn/static/img/QIU-kRtdSKlZXMFnXtf5mCeokJU_Ekr9D4ieW3raSENweul2wDyQPzATGfVkgB6e.jpg");
		qrcodeMap.put(6952, "http://wap.xbcare.com.cn/static/img/HI2pIB0lhg_t5uHc2D3Clv1_v5acrSapF0UTXZYLzrTdTOePuUYU1fl_d4IIGSJr.jpg");
		qrcodeMap.put(6868, "http://wap.xbcare.com.cn/static/img/mNGhsOJ6lV0xUNI84aaJ86Hqni3i47M0RhUR1hRqWt7qx2sAhSzeoVR8hK4KgWK6.jpg");
		qrcodeMap.put(6911, "http://wap.xbcare.com.cn/static/img/RfQmOp28ou9rqzxq30j8UA3kN_MjV5xKFAxK3jersSQNU89AwhdzkedLQp09qbGZ.jpg");
		qrcodeMap.put(863, 	"http://wap.xbcare.com.cn/static/img/ohj-SSTR4Keq1nFOeLiFmPUWCtIxhBREN_jrw4c9GwmfgmTocPS3API3OLpYc4DZ.jpg");
		qrcodeMap.put(6987, "http://wap.xbcare.com.cn/static/img/sVq5nX0mSwyqkj4bKIH0X_z8xHVsoTECCR9lAmUwiOJBns3SIGwFASjpG3TQYbqn.jpg");
		qrcodeMap.put(1184, "http://wap.xbcare.com.cn/static/img/fYxw4mVVUw1cPYJxjqRzfTTClxmLDvvse65WwCoFJGH_wMfKuwqvNrd6C5UXtD4y.jpg");
		qrcodeMap.put(6973, "http://wap.xbcare.com.cn/static/img/2gIQmtKEXfBQAh1ViwQk8Dd6FhnQ2T-Pu0xyjbqirQmjjqh7SJ0xNrHJcqm1EDBo.jpg");
		qrcodeMap.put(447, 	"http://wap.xbcare.com.cn/static/img/kH-ZQF7VUMBkHnE96JKeZK0tEbd98116F1tqhOlOgM1I7ifloSbvA5pG6im2mw8H.jpg");
		qrcodeMap.put(1783, "http://wap.xbcare.com.cn/static/img/pcgc6Fm3NFyzkoWim7iXQ1ndIF0WYRl4bn1G_50K5xZB5aRspgZDnYuas9FW4wAT.jpg");
		qrcodeMap.put(1201, "http://wap.xbcare.com.cn/static/img/ej1dLG0ppkL3BSBwI8Piz62sSDuDJhT_aZw7ZigdgOrJZfaRpZADWMgFaKRz24YG.jpg");
		qrcodeMap.put(7058, "http://wap.xbcare.com.cn/static/img/LE-JRzec_ikAJZJRZT02kJJtOULpIjdgGYxJsCl335WtF9eyS7SJd85_u1oCU2-u.jpg");
		qrcodeMap.put(7054, "http://wap.xbcare.com.cn/static/img/7rubJBsk5lSvKZZK-lqZmum5mYt0guJzxE0O9wfeGtAggfzEhqlj3iIcTZ3AQncP.jpg");
		qrcodeMap.put(7057, "http://wap.xbcare.com.cn/static/img/DfDnvX_vNvPAL0LdAo-m41DiYIxLoOJrAJ_VAHBIflliLts5B3mgE9mHWx5QLIQj.jpg");
		qrcodeMap.put(2329, "http://wap.xbcare.com.cn/static/img/Q3ajWT_-jwoiwiC8BwtiDSZMROL5w869uYztcZzgDHiCGUTwMTdj9Jtr_zDt55aY.jpg");
		qrcodeMap.put(7062, "http://wap.xbcare.com.cn/static/img/X2eqoNuuVc-wAsIjn5ZIRA3PNyeETF6sMHMv2hn40mV8U7CoTng8S8VedyVQl4Tm.jpg");
		qrcodeMap.put(7056, "http://wap.xbcare.com.cn/static/img/juQ7FqM_eJs4ey4_G5zk_PBESdOw3D0E-wogSfXIYQf_ejorSeV3g0drlc8GHYhk.jpg");
		qrcodeMap.put(361, 	"http://wap.xbcare.com.cn/static/img/0z7Lch09SnuwxlzRqVyXQEjSoxQ1o5OVVp9O9qQ4j58JEMWSrsn_eGAuwbcKPA60.jpg");
		qrcodeMap.put(7055, "http://wap.xbcare.com.cn/static/img/jm_3O67_ZQfHyG7yxQmeNwcm2qZt7whmX0IweWGoHPD6JcMDxHfXOdLrl6otkPTW.jpg");
		qrcodeMap.put(7118, "http://wap.xbcare.com.cn/static/img/2tXm9tI6VZxzGFlZ-DsQyqs4J5oU2UWnARBJR9jMvJqSJkyQok-Z0jlQxIClP9YI.jpg");
		qrcodeMap.put(6139, "http://wap.xbcare.com.cn/static/img/1vWwS7vCrTxaznMSz8cl8FEHtbdzaU6x19kgEjXHnenaoapfw024Xeg8vDLMtCOD.jpg");
		qrcodeMap.put(6942, "http://wap.xbcare.com.cn/static/img/Tb-pjC9oX69HhtiU5ll4DTIYxp4dsJAYn4pTeLxG5vMjypGkU-yXAzt75DK8G6Tl.jpg");
		qrcodeMap.put(7105, "http://wap.xbcare.com.cn/static/img/dAF47WrpmJykMfFUbRhiHiWHMlruLXj8Kg7aednlRtQikaQRn1okc6NQM5fpUoN6.jpg");
		qrcodeMap.put(7119, "http://wap.xbcare.com.cn/static/img/h-Bsw-pjzcKtluWVtZuMCqNz1RhDB4ne3dI5nQamDS_pzyjWtadIDAEloztbR9Nl.jpg");
		qrcodeMap.put(7130, "http://wap.xbcare.com.cn/static/img/-jkf8oXaPSewuLaIXfgeWOk2NCnaebCxJO0PBKgzL8lYDOxIYWgwjXNe2_KCqKs1.jpg");
		qrcodeMap.put(470, 	"http://wap.xbcare.com.cn/static/img/Z8ubLZ0wabZeqxa5BtZ2WpuV5c1Hm6Lr43wwxilhqt_3OTltJyB7wkG6A1vF5xSt.jpg");
		qrcodeMap.put(2344, "http://wap.xbcare.com.cn/static/img/Efft7PRemM53URjgdj7EpMwtE6KJ1-42C3vWvSnwo4cliKxFeaxTY0iQ8ZMrncrC.jpg");
		qrcodeMap.put(6180, "http://wap.xbcare.com.cn/static/img/4gu3qmwuJa6PjPkydSUl8tqKBc6IQlxiEWLYyhwyDxeHh6E25zNXH8ySw_8zzelS.jpg");
		qrcodeMap.put(1220, "http://wap.xbcare.com.cn/static/img/ATprvUoI21x5Yt-WElpifjBCtZpab6_QM3Z9TYU9qDg-AtN4eesjQW0EVwXdaRX_.jpg");
		qrcodeMap.put(2332, "http://wap.xbcare.com.cn/static/img/bKVyowTqyadT8ae_JVmATGDD6lSFhMS4JxyCGaowq-Tp7LgvJjeD7lf7XXbhvOWf.jpg");
		qrcodeMap.put(836, 	"http://wap.xbcare.com.cn/static/img/_P2pmMHBIlNpSi4F-0DKyRaqzNj69Cxbh4JuouobTOaXGzYOt4SdtT4j9zC7eljO.jpg");
		qrcodeMap.put(6284, "http://wap.xbcare.com.cn/static/img/XEeXJITp9PpUkmegMdCa0XYeLdDDnU_67HbC8qD9zLxIUG9S9coNaprfhVqKHlzp.jpg");
		qrcodeMap.put(572, 	"http://wap.xbcare.com.cn/static/img/43BFBMK9jOUuDk8IZqJryPzKHUs3v_oQQgvcqV3GKj-VUfESJ77HJtkr-stdqgIW.jpg");
		qrcodeMap.put(6170, "http://wap.xbcare.com.cn/static/img/R-Atr6ibdVCrqcT2RMXTpB6dIDML4ciPCsVNisdCovpn9JIJqtI0M5G6bt_dZbLJ.jpg");
		qrcodeMap.put(2341, "http://wap.xbcare.com.cn/static/img/Z8ubLZ0wabZeqxa5BtZ2WkzkhUvx5EH_792PIH6Nksdqno538yX4h3dG1e_GmmxD.jpg");
		qrcodeMap.put(7154, "http://wap.xbcare.com.cn/static/img/8-37bYnqS0YFxvuQzMXJt-vQmdLv0kLXV44akEuhttIylznmFeGJqbKVgpYROJ-a.jpg");
		qrcodeMap.put(7153, "http://wap.xbcare.com.cn/static/img/hwsomgWuYIg6t0l0skMhQ8EWIFc5HmMNNUDWnqu8woboaY9j5dH_an0gRLU3BBOR.jpg");
		qrcodeMap.put(1787, "http://wap.xbcare.com.cn/static/img/l-xmw1w-I9mXvBYo7dVVAIHJCnobBpSxZfUkhT9AgtMjUMs3ooppLgwwb7UKLAAS.jpg");
		qrcodeMap.put(580, 	"http://wap.xbcare.com.cn/static/img/8TchCPmiAveZ90WfmADFV7Oin69FX2wZgCm9G4OcvNzQ2toUW91eA6H77KULa2qv.jpg");
		qrcodeMap.put(7175, "http://wap.xbcare.com.cn/static/img/OHyLtcrz8caubOHykaAMSlAgmbtrp4WSlJ1umtPJd8PjGqH0iYWmIfsDVZF5ASmX.jpg");
		qrcodeMap.put(7014, "http://wap.xbcare.com.cn/static/img/_TAegou9jVxQKIDGSsS1XQ4mEPPN77gYmNgGaBLB3-RgzhynrfCCcvMR5AIjfjfS.jpg");
		qrcodeMap.put(1171, "http://wap.xbcare.com.cn/static/img/kZv6RPlIU7ZbdpeT6hxzppL06B8oxyfoukwTnstA-ly6Qd4duwl2x-ybgndhZYnX.jpg");
		qrcodeMap.put(307, 	"http://wap.xbcare.com.cn/static/img/JqGpNsPfSsFWCIWGKjBXGSol8OCEpUUMuX9VAbhXa82yOpw6e7i0pOjI2BUAZSW9.jpg");
		qrcodeMap.put(5487, "http://wap.xbcare.com.cn/static/img/cUbpq1jFMR6mmIBiRysWtt4vfYh5UBzaPMnfnOJNhOfHDYfIjEyKvZvT5rwpybCY.jpg");
		qrcodeMap.put(6418, "http://wap.xbcare.com.cn/static/img/NiukGHuvVF3meH89xrja2z0GEH5LBWKqmapqUiq78DAquoTDRJlZ2p1MCInY-EuZ.jpg");
		qrcodeMap.put(6264, "http://wap.xbcare.com.cn/static/img/cl1g_B2zz5rUIRD9JNtZAjA43LO62IcFK5iT2lqhPfCdZ--jQ7p-90oQpc9YFjB-.jpg");
		qrcodeMap.put(511, 	"http://wap.xbcare.com.cn/static/img/JJhzQoLkaVZgp6jJKuytHkIGRn_H-4InSz7Rkk7LFqlUiLU8MflVAqCU_Fl3CznO.jpg");
		qrcodeMap.put(7052, "http://wap.xbcare.com.cn/static/img/SFTdcsuubc7icOuUW5rhobXr8Hn1YcQJV0ZkHQyzT5mtYQN3QwgshGGA9Rj31UkO.jpg");
		qrcodeMap.put(2333, "http://wap.xbcare.com.cn/static/img/zbV6zbAd2LILKe0-m3Hyfh0LrV50YP08c3kn_objLavY00w3SCVJvunaxaz05Z_2.jpg");
		qrcodeMap.put(6448, "http://wap.xbcare.com.cn/static/img/fjXOmmEFXyieYVQrnX14KCYBxtawg1xQT38JdvRLXE677rytVEl8tD8LStP4twtz.jpg");
		qrcodeMap.put(374, 	"http://wap.xbcare.com.cn/static/img/DHER1FjuuvzKArJqtAPHaofVx09dP_7U3-RQrR3qy1TPVU52CrQACuY6l2TIeP_E.jpg");
		qrcodeMap.put(2481, "http://wap.xbcare.com.cn/static/img/wiIRO3qcbXiagtkOS6SGKN5r9MSCUzF6nMkyNrl9qFnl38muyzxSQpSs5L3YHkEB.jpg");
		qrcodeMap.put(2485, "http://wap.xbcare.com.cn/static/img/OtXPiNrCgSpTCp9_Z63yk82Z3W1joIAqgNam6kbU1-ARBwErw9kE84-iFCvDy2Hu.jpg");
		qrcodeMap.put(7167, "http://wap.xbcare.com.cn/static/img/nIv7LWP1B0JYie-0y1Ne1OJA_ovmeCN7kv9Yk_hVLBp-Eqt51oC6Zg5d4tTmFFDa.jpg");
		qrcodeMap.put(7176, "http://wap.xbcare.com.cn/static/img/LP6J4yireRKzUSZaRConPG8CweZLwgFfArqnrkgxBBkxdHZFziE-iM5N74aMAV2g.jpg");
		qrcodeMap.put(7178, "http://wap.xbcare.com.cn/static/img/98DWJQCMLG0WLUOZHElq_R9sPdVcU2Rify--CZ5JQqD0UPiX5qOeCblGV5Lt9bhN.jpg");
		qrcodeMap.put(7166, "http://wap.xbcare.com.cn/static/img/6e0bH75QUJCq_tP7Od6SDDw07MpWDIaCWZCafMj1zpp5Ym5XxmbisEzebWaRqS17.jpg");
		qrcodeMap.put(7165, "http://wap.xbcare.com.cn/static/img/DR-M13vLUTHfdoQJOiH2jCoKdM0a8m92Zc5zESju1U-o5pg5DpqEkmt2FMzbm5ex.jpg");
		qrcodeMap.put(7173, "http://wap.xbcare.com.cn/static/img/yPj2wPGgDC1xrpVzGhl7gbIhbsazBTUsUaqb4fWeyzkvSeLgnQY_ayHpAgJ1QHKF.jpg");
		qrcodeMap.put(350, 	"http://wap.xbcare.com.cn/static/img/Z6jUsDztgR0uS80U6aqd00YAt92dWdlVfp3E9eOaGGcojKLixlhuz_aJ1IqYfAah.jpg");
		qrcodeMap.put(867, 	"http://wap.xbcare.com.cn/static/img/bgzBLQAnth3OPo7QHS8LLzCTb8V2t7NWRKfWoAmQPN_znQ0f_3RRbrahXPBhpSOc.jpg");
		qrcodeMap.put(6137, "http://wap.xbcare.com.cn/static/img/ivXs2uqem0gT-PBF0lY8MnoCp0YpeJE-NTyfCMfyYCcFwFYZWbfCRyovAOficFa2.jpg");
		qrcodeMap.put(838, 	"http://wap.xbcare.com.cn/static/img/mmyqTetfyZ06TE4oCB-EasGVkRPf_-vaftp5eFr8EazoU3je0S9zW-yqhFDNiA1L.jpg");
		qrcodeMap.put(338, 	"http://wap.xbcare.com.cn/static/img/QYJk_kNCnXo3OP5D2T6W3yrzme2LnFE_BZI--0-hXbXKiNefro0XP6dL5DiSN3Ai.jpg");
		qrcodeMap.put(6675, "http://wap.xbcare.com.cn/static/img/aJGAD8Tp-lDTGtBn_D3RxOY5id-5N8l23YM_i9pgfStWwzcmg7BnaM7AxejDEM45.jpg");
		qrcodeMap.put(7018, "http://wap.xbcare.com.cn/static/img/doT9mQM2obkcGDYPeuIl2X9e_NbJUpm1tPCUalkhLLwkwgSP6TeJTgybTYnoiMTk.jpg");
		qrcodeMap.put(7224, "http://wap.xbcare.com.cn/static/img/zCdRJ0HNywsC3hdGY5hw8LXnwMwzfCF_eRtmzXDrEJ0GBKhDc8C-BEYMUUBTXtCj.jpg");
		qrcodeMap.put(7132, "http://wap.xbcare.com.cn/static/img/OYBA8VisHcAbVkGiHF4Ufdqg0zmCXlXyR8N_p9-mo1or7dp_i1qys3-E_krEeTSP.jpg");
		qrcodeMap.put(7249, "http://wap.xbcare.com.cn/static/img/nK8Upf7GZKDBWc_x97Yoi8ZpdLuKRbNiQfqcJwyWKkSGLGYdr54NXA0EZVJfTwGy.jpg");
		qrcodeMap.put(7053, "http://wap.xbcare.com.cn/static/img/0-vLJe2QSiZIJLh_8j-IEgfhxjqQoSJCjuXDMW_drBa5EArAhVuNLzN4d3dj2r-F.jpg");
		qrcodeMap.put(7295, "http://wap.xbcare.com.cn/static/img/s1u4McSuEEycQ4raNuDfbD44Q-9YL7cVpIM7w7UnOC3d1x0bh_kbMVzgyWXDHvCX.jpg");
		qrcodeMap.put(7298, "http://wap.xbcare.com.cn/static/img/42bRQgDVEJdyV5CTTW2irUC1xcD4pH70Wba7DL3fS0UafCcW2-twAT2MZvZ3bvTg.jpg");
		qrcodeMap.put(7296, "http://wap.xbcare.com.cn/static/img/CD4f1zxR50X779X0rkpPS7R75yW0TfKe60UvNpVq_pBWtqY6FPuR1-nZETUQf2fF.jpg");
		qrcodeMap.put(7299, "http://wap.xbcare.com.cn/static/img/42bRQgDVEJdyV5CTTW2irZejEhU2R2uNnEt3ZCErF39JcrdGrhXqJdPnTdmZtami.jpg");
		qrcodeMap.put(7294, "http://wap.xbcare.com.cn/static/img/N_4JNkybAfyvQT8q78v8sQLgiwgxk5GLwdD535DS8AoFpVkD_BiqfIj_X_A3vp8C.jpg");
		qrcodeMap.put(7297, "http://wap.xbcare.com.cn/static/img/kRa0UtmsFGxZKaVhEemWZiT2RD888bxsDm8uan4bIeFfZajAxv54lgeNJzXWunR_.jpg");
		qrcodeMap.put(7293, "http://wap.xbcare.com.cn/static/img/hYVdeqav1ayEluR___s-dpo5QDEioRwjk7Z3Qv7Pc0Or2z583oTsMQ-9dwwOdfy3.jpg");
		qrcodeMap.put(7272, "http://wap.xbcare.com.cn/static/img/n_HKcc5l7fzrj3wNnjG0_Ld_xYH-HQalw0oXwgPcCmI7iED_uAJyGe004Wnd2qZD.jpg");
		qrcodeMap.put(7289, "http://wap.xbcare.com.cn/static/img/xllONyg2l9DGx8RXwhnlMULV3R8ATn_p4eCreHi597sWgVMVT-4abOP8c9fphqep.jpg");
		qrcodeMap.put(7290, "http://wap.xbcare.com.cn/static/img/XhNJA8CfdIRxx_jYvGTnvPMXhcHJnxLfSyBpwwvIoYN9Q6NG3ttcRMOqSjAILuwm.jpg");
		qrcodeMap.put(7286, "http://wap.xbcare.com.cn/static/img/OblInm5_3rlb2sApBAAMwrczF6cFZ5KPhmIq-PstZ1FB-M5PHzsX7rzEaHc_EijN.jpg");
		qrcodeMap.put(7263, "http://wap.xbcare.com.cn/static/img/kRa0UtmsFGxZKaVhEemWZv7R-KpDcoK1EDE05xFhfdJyrYnBrl_4zJTPAJQkPizY.jpg");
		qrcodeMap.put(7288, "http://wap.xbcare.com.cn/static/img/42bRQgDVEJdyV5CTTW2irb5PNHhzjBtOAAKC2vVTDE7psaB4juqkhTH2avOfQ2Wf.jpg");
		qrcodeMap.put(7287, "http://wap.xbcare.com.cn/static/img/xzW77j2X19AMNKkm4Yr6ZafiE67VM_lnOs2yvdBPdo-rTx8uWmSgMS8dxflW6bC-.jpg");
		qrcodeMap.put(7285, "http://wap.xbcare.com.cn/static/img/42bRQgDVEJdyV5CTTW2irbFGpOwhHkaqjS8a309_qRlkWv0jOuBQeSrMWfmfocov.jpg");
		qrcodeMap.put(7284, "http://wap.xbcare.com.cn/static/img/k7lPM3k6wVA23LsFmANSf1uGMOLBZe0SiYia3uH62QU7BzDSdJjVidjH7okZe4M9.jpg");
		qrcodeMap.put(7283, "http://wap.xbcare.com.cn/static/img/KJe0PyLv2taWPM2Ypi7Wt0Exxf4AkldYmuYVs44OPFz2IGUqvai2FZoKQJ0x6Vti.jpg");
		qrcodeMap.put(7280, "http://wap.xbcare.com.cn/static/img/97QSg62CxPcsK72M5YyXW4uarNzMy0hLr8oNYpjRI-IuH15z1kdqXK3ly9WSJt0S.jpg");
		qrcodeMap.put(7269, "http://wap.xbcare.com.cn/static/img/zYdt1HVEQzGmVb5SvKb4WwZojYH4q9sER0K8y-hrj4dncLFdd_-lHL6m--r6T6hc.jpg");
	}
	
	@Test
	public void decode2() throws Exception {
		List<Map<String, Object>> resultList = Lists.newArrayList();
		int successNum = 0;
		for(Integer userId : qrcodeMap.keySet()){
			String qrcodeUrl = qrcodeMap.get(userId);
			BufferedImage bufferedImage = ImageIO.read(new URL(qrcodeUrl));
			LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap bitmap = new BinaryBitmap(binarizer);
			HashMap<DecodeHintType, Object> decodeHints = new HashMap<DecodeHintType, Object>();
			decodeHints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result decodeResult = null;
			try {
				decodeResult = new MultiFormatReader().decode(bitmap, decodeHints);
			} catch (Exception e) {
			}
			
			Map<String, Object> item = Maps.newHashMap();
			item.put("userId", userId);
			item.put("imageUrl", qrcodeUrl);
			if(null != decodeResult){
				item.put("qrcode", decodeResult.getText());
				successNum += 1;
			}
			resultList.add(item);
		}
		System.out.println(successNum);
//		System.out.println(JSON.toJSONString(resultList));
	}
}
