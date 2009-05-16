package com.netsoft.util.tag;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import com.netsoft.dao.imp.MenusDao;
import com.netsoft.dao.imp.RolesDao;
import com.netsoft.dao.intf.IMenusDao;
import com.netsoft.dao.intf.IRolesDao;
import com.netsoft.dao.pojos.Menus;

/*
 * ��ɫ���ӣ�ά����ʾȨ�ޱ��
 */
public class RoleInitTag extends BodyTagSupport {

	private String listName;
	private String scope;
	private String role;// Ҫȡ��һ�����Ȩ�� 0Ϊȫ�� -1 Ϊϵͳ��Դά�� -2 �ͻ���Դ���� -3 Ϊ�ۺϲ�ѯ���� -4
						// Ϊ��������Ȩ��(�����Ƶ������Ȩ��)
	Logger log = Logger.getLogger(this.getClass());

	@Override
	public int doEndTag() throws JspException {
		String body = this.getBodyContent() == null ? "" : this
				.getBodyContent().getString();
		JspWriter out = pageContext.getOut();
		List<Menus> topMenus = new ArrayList();
		List<Menus> owenList = null;
		// ȡ���û���Ȩ��
		if (body != null && !"".equals(body)) {
			log.info("��ǩ����������.....");
			log.info("�����ǣ�" + body);
			owenList = (List<Menus>) pageContext.getRequest().getAttribute(
					"rolelist");
		}
		try {
			StringBuffer sb = new StringBuffer();
			List<Menus> list = new ArrayList();
			// ���������ȡ�÷����������еĶ���
			if (scope.equals("session")) {
				list = (List) pageContext.getSession().getAttribute(listName);
			} else {
				list = (List) pageContext.getRequest().getAttribute(listName);
			}
			sb
					.append("<table  cellspacing=1 cellpadding=0 border=0 id=bgtable width=100% align=center><tr><td id=bgtitle colspan=2 align=center>");
			if ("-1".equals(role)) {
				sb.append("ϵͳ��Դά��");
			} else if ("-2".equals(role)) {
				sb.append("�ͻ���Դ����");
			} else if ("-3".equals(role)) {
				sb.append("�ۺϲ�ѯ����");
			} else if ("-4".equals(role)) {
				sb.append("��������Ȩ�޹���");
			}
			for (Menus menus : list) {

				if (menus.getMtopId() == Integer.parseInt(role)) {
					topMenus.add(menus);
				}
			}
			// ȡ�ڶ����˵�
			int i = 1;
			for (Menus menus : topMenus) {
				sb.append("</td></tr><tr><td width=80 id=bgbody align=left>")
						.append(menus.getMname()).append(
								"</td><td id=bgbody align=left width=700>");
				log.info("���˵���" + menus.getMname());
				for (Menus menus2 : list) {
					if (menus2.getMtopId().equals(menus.getId())) {
						if (owenList == null || owenList.size() <= 0) {

							sb.append(
									"<input type='checkbox' name='rmidptables"
											+ role.substring(1) + "' value='"
											+ menus2.getId() + "'>&nbsp;")
									.append(menus2.getMname());
						} else {
							boolean flag = false;// ��ʼ��־
							for (Menus menus3 : owenList) {
								// ѭ����ʾ����Ȩ��
								// log.info(menus2.getId()+":"+menus2.getMname()+"==="+menus3.getId()+":"+menus3.getMname());
								// log.info(menus2.getId()==menus3.getId());
								// log.info(menus2.getId().equals(menus3.getId()));
								// log.info(String.valueOf(menus2.getId()).equals(String.valueOf(menus3.getId())));
								if (menus2.getId().equals(menus3.getId())) {
									flag = true;
									break;
								}
							}
							if (!flag) {
								sb.append(
										"<input type='checkbox' name='rmidptables"
												+ role.substring(1)
												+ "' value='" + menus2.getId()
												+ "'>&nbsp;").append(
										menus2.getMname());
							} else {
								sb.append(
										"<input type='checkbox' checked=checked name='rmidptables"
												+ role.substring(1)
												+ "' value='" + menus2.getId()
												+ "'>&nbsp;").append(
										menus2.getMname());
							}
						}
					}
				}
				sb.append("</td></tr>");
			}

			sb
					.append("<tr><td colspan=6 id=bgbody><input type=button value=ȫѡ onclick=selall('rmidptables"
							+ role.substring(1)
							+ "') class=mybutton><input type=button value=��ѡ class=mybutton onclick=self('rmidptables"
							+ role.substring(1) + "') ></td></tr></table>");
			log.info(sb.toString());
			out.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
