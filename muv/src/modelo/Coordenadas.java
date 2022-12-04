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

	public Float distancia(Coordenadas c) {
		Float graus = (float) Math.sqrt(Math.pow(this.latitude - c.latitude, 2) + Math.pow(this.longitude - c.longitude, 2));
		Float km = graus*(float)110.574;
		return km;
	}
	
}