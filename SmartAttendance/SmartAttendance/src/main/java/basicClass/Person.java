package basicClass;

public class Person {
    protected String name;
    protected String phoneNumber;

//    FaceInf;人脸信息
    protected boolean sex;//false:woman ;true:man
    public Person(String name,String phoneNumber,boolean sex){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.sex=sex;
    }
    public Person(){
        this(null,null,true);
        System.out.println("no information insert!");
    }
}
