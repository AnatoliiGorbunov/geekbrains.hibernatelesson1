package ru.geekbrains.hibernatehomework1;

public class Main {
    public static void main(String[] args) {

       SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
       sessionFactoryUtils.init();
       try{
           ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
           productDao.saveOrUpdate(new Product("Orange",90));
           System.out.println(productDao.findById(2l));
           System.out.println(productDao.findAll());
           productDao.deleteById(2l);
           System.out.println(productDao.findAll());
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           sessionFactoryUtils.shotDown();
       }
    }
}
