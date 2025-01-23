package src.main.java.com.example.demo.behaviorialdp.MomentoDP;

public class ConfigurationOriginator {
    int height;
    int width;

    public ConfigurationOriginator(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ConfigurationMomento createMomento(){
        return new ConfigurationMomento(this.height,this.width);
    }

    public void restoreMomento(ConfigurationMomento undomomento){
        this.height= undomomento.height;
        this.width= undomomento.width;
    }

}
