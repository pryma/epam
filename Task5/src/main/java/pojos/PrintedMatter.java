package pojos;

public abstract class PrintedMatter {

    private String id;
    private String pages;
    private String sort;

    public PrintedMatter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "PrintedMatter{" +
                "id='" + id + '\'' +
                ", pages='" + pages + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
