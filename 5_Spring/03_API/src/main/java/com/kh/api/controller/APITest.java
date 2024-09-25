package com.kh.api.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class APITest {

	public static void main(String[] args) {
//		try {
////		XMLParsing
//		String serviceKey = "5NYuVSB%2Bh2EewCqNb8dOzOKX%2FNRdcv9hemVoR%2BBXayVmIqo7k9Pwir80dic8IipuXa1ThAMmAba9lVxqrnMbrQ%3D%3D";
//		String urlString="http://openapi.seoul.go.kr:8088/sample/xml/LOCALDATA_072404_DJ/1/5/";
//		
//		URL url = new URL(urlString);
//		
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setRequestMethod("GET");
//		
//		// 응답 읽기
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        StringBuilder responseBuilder = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            responseBuilder.append(line);
//        }
//        reader.close();
//        connection.disconnect();
//		
//     // XML 문자열
//        String xmlResponse = responseBuilder.toString();
//        System.out.println("XML Response: \n" + xmlResponse);
//
//        // XML 파싱
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(new InputSource(new StringReader(xmlResponse)));
//        
//        document.getDocumentElement().normalize();
//        
//     // 특정 XML 노드 찾기 (예: "row" 노드, XML 구조에 따라 수정 필요)
//        NodeList nodeList = document.getElementsByTagName("row");
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Element element = (Element) nodeList.item(i);
//            // 필요한 데이터 추출 (예: "RSTR_NM", "AREA_NM" 등, XML 구조에 맞게 수정 필요)
//            String SITEWHLADDR = element.getElementsByTagName("SITEWHLADDR").item(0).getTextContent();
//            String BPLCNM = element.getElementsByTagName("BPLCNM").item(0).getTextContent();
//            String X = element.getElementsByTagName("X").item(0).getTextContent();
//            String Y = element.getElementsByTagName("Y").item(0).getTextContent();
//            String SITETEL = element.getElementsByTagName("SITETEL").item(0).getTextContent();
            
//          Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.10.28:3306/forever404", "root", "qwer1234");
//			String query="INSERT INTO service_info(si_type, service_name, service_jibun, service_lat, service_lng, service_phone) VALUES(?, ?, ?, ?, ?, ?)";
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ps.setInt(1,1);
//			ps.setString(2,BPLCNM);
//			ps.setString(3,SITEWHLADDR);
//			ps.setString(4,X);
//			ps.setString(5,Y);
//            ps.setString(6,SITETEL);
//			ps.executeUpdate();
//			
//			for(int i = 0; i < nList.getLength(); i++) {
//				Node nNode = nList.item(i);
//				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
//					Element eElement = (Element) nNode;
//					System.out.println("MAIN_TITLE : " + getTagValue("MAIN_TITLE",eElement));
//					System.out.println("ADDR1 : " + getTagValue("ADDR1", eElement).trim());
//					System.out.println("---------------------------------");
//				}
//			}
//        }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		JSONParsing
		String serviceKey = "1blmw7FfsjIHx6bW417a9gmMNh2dPcbfxWUIaXNzSrCJWnzOj6qPvzabOdeelgJh";
		String url="https://seoul.openapi.redtable.global/api/rstr?serviceKey=" + serviceKey + "&pageNo=1";
		
//		try {
//			URL requestUrl = new URL(url);
//			HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
//			urlConnection.setRequestMethod("GET");
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//			String line = null;
//			
//			StringBuffer responseBuffer = new StringBuffer();
//			
//			while((line=br.readLine())!=null) {
//				responseBuffer.append(line);
//			}
//			br.close();
//			urlConnection.disconnect();
			
//			String responseData = responseBuffer.toString();
//			System.out.println(responseData);
			
//			JSONObject jsonResponse = new JSONObject(responseData);
			
//			JSONObject jsonData = jsonResponse.getJSONObject("rstr");
//			System.out.println(jsonData);
			
//			JSONArray items = jsonResponse.getJSONArray("body");
			
//			for(int i=0; i < items.length(); i++) {
//				JSONObject result = items.getJSONObject(i);
//				System.out.println(result.getString("RSTR_NM"));
//				System.out.println(result.getDouble("RSTR_LA"));
//				System.out.println(result.getDouble("RSTR_LO"));
//				System.out.println("--------------------------------");
				
				
				
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.10.28:3306/forever404", "root", "qwer1234");
//				String query="INSERT INTO service_info(si_type, service_name, service_jibun, service_lat, service_lng, service_phone) VALUES(?, ?, ?, ?, ?, ?)";
//				PreparedStatement ps = conn.prepareStatement(query);
//				
//				ps.setInt(1,1);
//				ps.setString(2,BPLCNM);
//				ps.setString(3,SITEWHLADDR);
//				ps.setString(4,X);
//				ps.setString(5,Y);
//	            ps.setString(6,SITETEL);
//				ps.executeUpdate();
//			}
//	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		JDBC
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.10.28:3306/forever404", "root", "qwer1234");
//			String query="INSERT INTO service_info(si_code, service_name, service_jibun, service_lat, service_lng, service_phone) VALUES(?, ?, ?, ?, ?, ?)";
//			PreparedStatement ps = conn.prepareStatement(query);
			
//			ps.setInt(1,1);
//			ps.setString(2,BPLCNM);
//			ps.setString(3,SITEWHLADDR);
//			ps.setString(4,X);
//			ps.setString(5,Y);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				int siCode = rs.getInt("si_code");
//				String serviceName = rs.getString("service_name");
//				String serviceJibun = rs.getString("service_jibun");
//				double serviceLat = rs.getDouble("service_lat");
//				double serviceLng = rs.getDouble("service_lng");
//				String servicePhone = rs.getString("service_phone");
//				String serviceImg = rs.getString("service_img");
//				System.out.println(siCode + " / " + serviceName);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
		
	}
	public static String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		
		if(nValue==null) return null;
		return nValue.getNodeValue();
	}
}
