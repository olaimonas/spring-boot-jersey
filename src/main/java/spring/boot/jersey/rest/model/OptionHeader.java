package spring.boot.jersey.rest.model;

public class OptionHeader {
    private Long startIndex;
    private Long size;


    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }
}
