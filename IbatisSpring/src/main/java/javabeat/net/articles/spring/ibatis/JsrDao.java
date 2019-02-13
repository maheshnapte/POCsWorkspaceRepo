package javabeat.net.articles.spring.ibatis;

import java.util.List;

public interface JsrDao
{

    public List selectAllJsrs();
    public Jsr selectJsrById(String jsrID);

    public void insertJsr(Jsr insertJsr);
    public void deleteJsr(String jsrId);
    public void updateJsr(Jsr jsrWithNewValues);

}
