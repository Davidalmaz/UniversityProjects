#include <WiFi.h>

// Your WiFi credentials.
// Set password to "" for open networks.
char ssid[] = "Holocron"; 
char pass[] = "rebelC1.10P"; 

void setup() {
  pinMode(23, OUTPUT);
  Serial.begin(115200);
  Serial.print("Connecting WiFi: ");
  Serial.println(ssid);

  /* Explicitly set the ESP32 to be a WiFi-client, otherwise, it by default,
     would try to act as both a client and an access-point and could cause
     network-issues with your other WiFi-devices on your WiFi-network. */
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, pass);
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  IPAddress ip = WiFi.localIP();
  Serial.println(ip);
}

void loop() {
  //Prueba Blink ESP32 con Relay
  //put your main code here, to run repeatedly:
  digitalWrite(23, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1000);                       // wait for a second
  digitalWrite(23, LOW);    // turn the LED off by making the voltage LOW
  delay(1000);                       // wait for a second
}
