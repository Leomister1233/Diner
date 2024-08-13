package edu.btbu.model.catalog;

public class Tray {
private String kind;
private SizeEnum size;

public Tray(String kind, SizeEnum size) {
	this.kind = kind;
	this.size = size;
}

public String getKind() {
	return kind;
}

public void setKind(String kind) {
	this.kind = kind;
}

public SizeEnum getSize() {
	return size;
}

public void setSize(SizeEnum size) {
	this.size = size;
}

@Override
public String toString() {
	return "Tray{" +
			       "kind='" + kind + '\'' +
			       ", size=" + size +
			       '}';
}
}
