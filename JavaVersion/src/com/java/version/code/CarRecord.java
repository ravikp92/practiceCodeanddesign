package src.com.java.version.code;

public record CarRecord(String a, String b) {
    public static int fill=10;

    public static void main(String[] args) {

        CarRecord carRecord=new CarRecord("hi","bi");
        System.out.println(carRecord.a);
        System.out.println(carRecord.b);

        String d="NORTH";
        System.out.println(
                switch (d){
                    case "NORTH","SOUTH": yield 5;
                    default: yield 4;
                }
        );
        //text blocks
        String sn= """
                Sean: "How are you"
                """;
        System.out.println(sn);
        System.out.println(sn.substring(5));

        String json= """
                {
                    "name": "john",
                    "age":23
                }
              """;

        System.out.println(json);
        switch ("test"){
//            case String s when s.length()>2: System.out.println(2);
        }
    }


    public CarRecord() throws IllegalAccessException {

        this("","");
    }
}


