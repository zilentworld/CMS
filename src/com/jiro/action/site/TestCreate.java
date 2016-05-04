package com.jiro.action.site;

import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.cxf.common.i18n.Exception;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by root on 5/2/16.
 */
public class TestCreate extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, ServletContextAware {

    private String testFile;
    private ServletContext servletContext;

    public String getTestFile() {
        return testFile;
    }

    public void setTestFile(String testFile) {
        this.testFile = testFile;
    }

    @Override
    public String execute() throws Exception {

        String realPath = servletContext.getRealPath("");

        System.out.println("safsdf");
        System.out.println("getRealPath:"+realPath);
        System.out.println("dasd");

        File source = new File(realPath + Constants.CMS_PATH_TO_SITE + "test.jsp");
        File dest = new File(Constants.CMS_PATH_TO_PENDING);

        try {
            FileUtils.copyFileToDirectory(source, dest);
        } catch (IOException e) {
            System.out.println("ERRRR");
            e.printStackTrace();
        }

        System.out.println("tttt");

        testFile = Paths.get(".").toAbsolutePath().normalize().toString();
        System.out.println("testFile:"+testFile);

        System.out.println("rrr");

        System.out.println("gasdg");
        File tiles = new File(realPath + Constants.CMS_PATH_TO_TILES);
        LineIterator it = null;
        try {
            it = FileUtils.lineIterator(tiles, "UTF-8");
            int a = 0;
            while (it.hasNext()) {
                System.out.println(a + ":" + it.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(it == null) {
                it.close();
            }
        }
        System.out.println("haawrh");

        System.out.println("aa");

        try {
            String tilesXml = FileUtils.readFileToString(tiles);
            System.out.println("bb");
            int closeQoute = tilesXml.indexOf("</tiles-definitions>");
            System.out.println("cc");

            String startTiles = tilesXml.substring(0, closeQoute);
            System.out.println("dd");
            String appendTiles = "<!-- testing append to tiles -->" + "\n";
            System.out.println("ee");
            String endTiles = tilesXml.substring(closeQoute);
            System.out.println("ff");

            FileUtils.writeStringToFile(tiles, startTiles + appendTiles + endTiles, "UTF-8");
            System.out.println("gg");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("asdasdas");

        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {

    }

    @Override
    public void setSession(Map<String, Object> map) {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
