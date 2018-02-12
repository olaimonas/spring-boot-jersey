package spring.boot.jersey.rest.model;

public class PageRequest {

    private Integer offset;
    private Integer size;

    public PageRequest(Integer offset, Integer size) {
        this.offset = offset;
        this.size = size;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
