#include <SPI.h>
#include <WiFi.h>

char ssid[] = "Holocron"; 
char pass[] = "rebelC1.10P"; 
int keyIndex = 0;

WiFiServer server(80);

void setup() 
{
  // put your setup code here, to run once:

  pinMode(23, OUTPUT);
  digitalWrite(23, LOW);

  /*pinMode(0, OUTPUT);
  digitalWrite(0, LOW);*/
  
  Serial.begin(115200);
  Serial.print("Connecting WiFi: ");
  Serial.println(ssid);

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, pass);
  while (WiFi.status() != WL_CONNECTED) 
  {
    Serial.print(".");
    delay(500);
  }
  IPAddress ip = WiFi.localIP();
  Serial.println(ip);
  server.begin();

}

void loop() 
{
  // put your main code here, to run repeatedly:

  WiFiClient client = server.available();

  if (client)
  {
    String currentLine = "";

    while (client.connected())
    {
      if (client.available())
      {
        char c = client.read();

        if (c == '\n')
        {
          if (currentLine.length() == 0)
          {
            client.println("HTTP/1.1 200 OK");
            client.println("Content-type:text/html");
            client.println();
            client.print("Value at A0 is");
            client.print(analogRead(A0));
            client.print("<br>");

            client.println();

            break;
          }

          else
          {
            currentLine = "";
          }
        }

        else if (c != '\r')
        {
          currentLine += c;
        }

        if (currentLine.endsWith("GET /H"))
        {
          digitalWrite(23, HIGH);
        }

        if (currentLine.endsWith("GET /L"))
        {
          digitalWrite(23, LOW);
        }

      }
    }
  }
}
