package modelo;

public class Coordenadas {
	float latitude;
	float longitude;
	
	public Coordenadas(float lagitude, float longitude) {
		this.latitude = lagitude;
		this.longitude = longitude;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
}