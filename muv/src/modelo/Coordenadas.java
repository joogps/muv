package modelo;

public class Coordenadas {
	float latitude;
	float longitude;
	
	public Coordenadas(float lagitude, float longitude) {
		this.latitude = lagitude;
		this.longitude = longitude;
	}
	
	public float getlatitude() {
		return latitude;
	}
	
	public void setlatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getlongitude() {
		return longitude;
	}
	
	public void setlongitude(float longitude) {
		this.longitude = longitude;
	}
	
}
