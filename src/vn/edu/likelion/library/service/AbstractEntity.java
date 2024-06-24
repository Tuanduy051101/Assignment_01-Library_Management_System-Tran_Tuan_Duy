package vn.edu.likelion.library.service;

public abstract class AbstractEntity implements Identifiable {
    protected int id;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
