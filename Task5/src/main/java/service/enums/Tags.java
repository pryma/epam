package service.enums;

public enum Tags {
    PRINTED_MATTER("printedMatter"),
    ID("id"),
    CATEGORY("category"),
    SORT("sort"),
    NAME("name"),
    AUTHOR("author"),
    PAGES("pages"),
    MAGAZINE("magazine"),
    BOOK("book"),
    LIBRARY("library"),
    STATISTIC("statistic");

    private String tag;

    private Tags(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return tag;
    }
}
