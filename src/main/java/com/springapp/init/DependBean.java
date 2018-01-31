package com.springapp.init;

/**
 * @author luobiao
 * @date 2017-06-27
 */
import java.io.IOException;
public class DependBean {
    ResourceBean resourceBean;
    public void write(String ss) throws IOException {
        System.out.println("DependentBean:=======写资源");
        resourceBean.getFos().write(ss.getBytes());
    }
    //初始化方法
    public void init() throws IOException {
        System.out.println("DependentBean:=======初始化");
        resourceBean.getFos().write("DependentBean:=======初始化=====".getBytes());
    }
    //销毁方法
    public void destroy() throws IOException {
        System.out.println("DependentBean:=======销毁");
        //在销毁之前需要往文件中写销毁内容
        resourceBean.getFos().write("DependentBean:=======销毁=====".getBytes());
    }

    public void setResourceBean(ResourceBean resourceBean) {
        this.resourceBean = resourceBean;
    }
}
