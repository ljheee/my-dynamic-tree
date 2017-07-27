package com.cvte.tree.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 临时测试使用
 */
@WebServlet("/dataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().print("[{\r\n" + 
				"	\"id\":1,\r\n" + 
				"	\"text\":\"My Documents\",\r\n" + 
				"	\"children\":[{\r\n" + 
				"		\"id\":11,\r\n" + 
				"		\"text\":\"Photos\",\r\n" + 
				"		\"state\":\"closed\",\r\n" + 
				"		\"children\":[{\r\n" + 
				"			\"id\":111,\r\n" + 
				"			\"text\":\"Friend\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":112,\r\n" + 
				"			\"text\":\"Wife\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":113,\r\n" + 
				"			\"text\":\"Company\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":114,\r\n" + 
				"			\"text\":\"Company2\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":115,\r\n" + 
				"			\"text\":\"Company3\"\r\n" + 
				"		}]\r\n" + 
				"	},{\r\n" + 
				"		\"id\":12,\r\n" + 
				"		\"text\":\"Program Files\",\r\n" + 
				"		\"state\":\"closed\",\r\n" + 
				"		\"children\":[{\r\n" + 
				"			\"id\":121,\r\n" + 
				"			\"text\":\"Intel\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":122,\r\n" + 
				"			\"text\":\"Java\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":123,\r\n" + 
				"			\"text\":\"Microsoft Office\"\r\n" + 
				"		},{\r\n" + 
				"			\"id\":124,\r\n" + 
				"			\"text\":\"Games\"\r\n" + 
				"		}]\r\n" + 
				"	},{\r\n" + 
				"		\"id\":16,\r\n" + 
				"		\"text\":\"Actions\",\r\n" + 
				"		\"children\":[{\r\n" + 
				"			\"text\":\"Add\",\r\n" + 
				"			\"iconCls\":\"icon-add\"\r\n" + 
				"		},{\r\n" + 
				"			\"text\":\"Remove\",\r\n" + 
				"			\"iconCls\":\"icon-remove\"\r\n" + 
				"		},{\r\n" + 
				"			\"text\":\"Save\",\r\n" + 
				"			\"iconCls\":\"icon-save\"\r\n" + 
				"		},{\r\n" + 
				"			\"text\":\"Search\",\r\n" + 
				"			\"iconCls\":\"icon-search\"\r\n" + 
				"		}]\r\n" + 
				"	},{\r\n" + 
				"		\"id\":13,\r\n" + 
				"		\"text\":\"index.html\"\r\n" + 
				"	},{\r\n" + 
				"		\"id\":14,\r\n" + 
				"		\"text\":\"about.html\"\r\n" + 
				"	},{\r\n" + 
				"		\"id\":15,\r\n" + 
				"		\"text\":\"welcome.html\"\r\n" + 
				"	}]\r\n" + 
				"}]\r\n" + 
				"");;
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sourceId = request.getParameter("sourceId");
		String FuId = request.getParameter("FuId");
		String moveText = request.getParameter("moveText");
		System.out.println("sourceId="+sourceId+"    ,FuId="+FuId+"    ,moveText="+moveText);
		
		
	}

}
