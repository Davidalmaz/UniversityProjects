#include <SPI.h>
#include <WiFi.h>
#include <IRremote.h>

char ssid[] = "Holocron";
char pass[] = "rebelC1.10P";
int keyIndex = 0;

const int ESP_PIN = 23;
const int ESP_PIN2 = 22;

WiFiServer server(80);

IRsend IrSender;

#if defined(ARDUINO_ARCH_SAMD)
#define Serial SerialUSB
#endif

void setup() 
{
  // put your setup code here, to run once:
  pinMode(ESP_PIN, OUTPUT);
  digitalWrite(ESP_PIN, LOW);
  pinMode(IR_SEND_PIN, OUTPUT);
  pinMode(22, OUTPUT);
  digitalWrite(22, LOW);
  pinMode(IR_SEND_PIN, OUTPUT);

  pinMode(ESP_PIN2, OUTPUT);
  digitalWrite(ESP_PIN2, LOW);
  pinMode(IR_SEND_PIN, OUTPUT);
  pinMode(22, OUTPUT);
  digitalWrite(22, LOW);
  pinMode(IR_SEND_PIN, OUTPUT);
  
  
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

#if defined(__AVR_ATmega32U4__) || defined(SERIAL_USB) || defined(SERIAL_PORT_USBVIRTUAL)
    delay(2000); // To be able to connect Serial monitor after reset and before first printout
#endif
    // Just to know which program is running on my Arduino
    Serial.println(F("START " __FILE__ " from " __DATE__));
    Serial.print(F("Ready to send IR signals at pin "));
    Serial.println(IR_SEND_PIN);

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

        // Funciones lampara/led

        if (currentLine.endsWith("GET /H"))    // Encender lampara
        {
          digitalWrite(ESP_PIN, HIGH);
          //digitalWrite(22, LOW);
          Serial.println("Signal sended\n");
        }
        
        if (currentLine.endsWith("GET /L"))    // Apagar lampara
        {
          digitalWrite(ESP_PIN, LOW);
          //digitalWrite(22, HIGH);
          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /X"))    // Encender led
        {
          digitalWrite(ESP_PIN2, HIGH);
          //digitalWrite(22, LOW);
          Serial.println("Signal sended\n");
        }
        
        if (currentLine.endsWith("GET /Z"))    // Apagar led
        {
          digitalWrite(ESP_PIN2, LOW);
          //digitalWrite(22, HIGH);
          Serial.println("Signal sended\n");
        }

        // Funciones TV 
        if (currentLine.endsWith("GET /W"))    // Botón Power (Encender/Apagar)
        {
          IrSender.sendNEC(0xE0E06798, 32);
          unsigned int BPRawData[9] = {8050,400, 2050,300, 2350,50, 2300,50, 54450};  // Protocol=UNKNOWN Data=0x1B00B5EE
          IrSender.sendRaw(BPRawData, 9, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /1"))    // Subir Volumen
        {
          unsigned int SVRawData[67] = {4550,4500, 600,1650, 600,1650, 600,1650, 600,550, 550,550, 600,550, 550,550, 600,550, 550,1700, 550,1700, 550,1700, 550,550, 600,550, 550,550, 600,550, 550,550, 600,1650, 600,1650, 600,1650, 600,550, 550,550, 600,550, 550,550, 600,550, 600,500, 600,550, 600,500, 600,1650, 600,1650, 600,1650, 600,1650, 600,1650, 600}; 
          IrSender.sendRaw(SVRawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /2"))    // Bajar Volumen
        {
          unsigned int BVRawData[67] = {4500,4550, 550,1700, 550,1700, 550,1700, 550,600, 500,600, 550,600, 500,600, 550,600, 500,1750, 500,1750, 500,1750, 500,600, 550,600, 500,600, 550,600, 550,550, 550,1700, 550,1700, 550,600, 550,1700, 550,550, 550,600, 550,550, 550,600, 550,550, 550,600, 550,1700, 550,600, 500,1750, 500,1750, 500,1700, 550,1700, 550}; 
          IrSender.sendRaw(BVRawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /3"))    // Mover Arriba
        {
          unsigned int MARawData[67] = {4600,4450, 600,1650, 600,1650, 600,1650, 600,550, 600,500, 600,550, 600,500, 600,550, 600,1650, 600,1650, 600,1650, 600,500, 600,550, 600,500, 600,550, 600,500, 600,550, 600,500, 600,550, 600,500, 600,550, 600,1650, 600,1650, 600,500, 650,1600, 650,1600, 650,1600, 650,1600, 650,1600, 650,500, 600,500, 650,1600, 650};
          IrSender.sendRaw(MARawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /4"))    // Mover Abajo
        {
          unsigned int MABRawData[67] = {4550,4500, 550,1700, 550,1700, 550,1700, 550,550, 600,550, 550,550, 600,550, 550,550, 600,1650, 600,1650, 600,1650, 600,550, 550,550, 600,550, 550,550, 600,550, 550,1700, 550,550, 600,550, 550,550, 600,550, 550,1700, 550,1700, 550,550, 600,550, 550,1700, 550,1700, 550,1700, 550,1700, 550,550, 600,550, 550,1700, 550};
          IrSender.sendRaw(MABRawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /5"))    // Mover Izquierda
        {
          unsigned int MIRawData[67] = {4600,4450, 600,1650, 600,1650, 600,1650, 600,550, 600,500, 600,550, 600,500, 600,550, 600,1650, 600,1650, 600,1650, 600,500, 600,550, 600,500, 600,550, 600,500, 600,1650, 600,550, 600,1650, 600,500, 600,550, 600,1650, 600,1650, 600,500, 600,550, 600,1650, 600,500, 650,1600, 650,1600, 650,500, 600,500, 650,1600, 650};
          IrSender.sendRaw(MIRawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /6"))    // Mover Derecha
        {
          unsigned int MDRawData[67] = {4600,4500, 600,1650, 600,1650, 600,1650, 600,500, 600,550, 600,500, 600,550, 600,500, 600,1650, 600,1650, 600,1650, 600,550, 600,500, 600,550, 600,500, 600,550, 600,500, 600,1650, 600,550, 600,500, 600,550, 600,1650, 600,1650, 600,500, 600,1650, 600,550, 600,1650, 600,1650, 600,1650, 600,500, 600,550, 600,1650, 600};
          IrSender.sendRaw(MDRawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /7"))    // Botón Seleccionar
        {
          unsigned int SRawData[67] = {4550,4500, 600,1650, 600,1650, 600,1650, 600,500, 600,550, 600,500, 600,550, 600,550, 550,1700, 550,1700, 550,1700, 550,550, 600,550, 550,550, 600,550, 550,550, 600,550, 550,550, 600,550, 550,1700, 550,550, 600,1700, 550,1650, 600,550, 550,1700, 550,1700, 550,1700, 550,550, 600,1700, 550,550, 550,550, 600,1700, 550}; 
          IrSender.sendRaw(SRawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        // Funciones A/A
        if (currentLine.endsWith("GET /8"))    // Encender/Apagar
        { 
          IrSender.sendNEC(0x800FF40C, 32);
          unsigned int EAARawData[67] = {2650,850, 400,450, 500,400, 450,850, 450,900, 1350,850, 450,400, 450,450, 500,400, 450,400, 450,400, 500,400, 450,400, 450,450, 500,400, 450,400, 850,450, 450,400, 500,400, 450,400, 500,400, 450,400, 450,450, 450,900, 800,900, 500,400, 450,400, 450,450, 500,400, 450,400, 900,400, 450,850, 450,450, 500};  // Protocol=RC6 Data=0x800FF40C
          IrSender.sendRaw(EAARawData, 67, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /9"))    // Subir Temperatura
        {
          IrSender.sendNEC(0x1363ADB4, 32);
          unsigned int STRawData[65] = {2650,850, 500,400, 500,400, 450,850, 500,800, 1400,850, 450,400, 450,400, 500,400, 500,400, 400,450, 500,400, 450,400, 400,500, 450,400, 500,400, 850,400, 500,400, 500,400, 400,900, 900,400, 450,400, 500,850, 850,900, 500,400, 450,400, 450,450, 450,400, 500,400, 900,400, 450,850, 450,450, 450};  // Protocol=UNKNOWN Data=0x1363ADB4
          IrSender.sendRaw(STRawData, 65, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /0"))    // Bajar Temperatura
        {
          unsigned int BTData[99] = {4450,4350, 600,1550, 600,500, 600,1550, 600,450, 600,500, 600,450, 600,500, 600,1550, 600,1550, 600,450, 600,1550, 600,500, 600,450, 600,500, 600,450, 600,500, 600,450, 600,1550, 600,500, 600,450, 600,500, 600,450, 600,1550, 600,500, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1550, 600,1600, 550,1600, 550,500, 600,1550, 600,1550, 600,500, 600,1550, 600,1550, 600,450, 600,500, 600};  // Protocol=SAMSUNG Data=0xA1A042FF
          IrSender.sendRaw(BTData, 99, 38);

          Serial.println("Signal sended\n");
        }
        
        //BLU-RAY
        if (currentLine.endsWith("GET /A"))    //Encender
        {
          unsigned int EBRRawData[41] = {2400,550, 1250,550, 600,550, 1250,550, 650,550, 1200,550, 650,550, 650,550, 600,600, 1200,550, 650,550, 1200,600, 1200,550, 650,550, 1200,550, 650,550, 650,550, 650,550, 1200,550, 1250,550, 1200};
          IrSender.sendRaw(EBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /G"))    //Open Disk
        {
          unsigned int OBRRawData[41] = {2400,550, 600,600, 1200,550, 1250,550, 600,600, 1200,550, 650,550, 600,600, 600,550, 1250,550, 650,550, 1200,550, 1250,550, 600,600, 1200,550, 650,550, 650,550, 600,550, 1250,550, 1250,550, 1200};
          IrSender.sendRaw(OBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }


        if (currentLine.endsWith("GET /B"))    //Mover Arriba
        {
          unsigned int MABRData[41] = {2500,550, 1300,550, 650,600, 650,550, 1250,600, 1300,600, 1250,600, 600,600, 600,650, 1200,650, 650,550, 1300,550, 1300,550, 650,600, 1200,650, 650,600, 650,550, 600,650, 1200,650, 1200,650, 1250};  // Protocol=UNKNOWN Data=0x884EBF5F
          IrSender.sendRaw(MABRData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /C"))    //Mover Abajo
        {
          unsigned int MABBRRawData[41] = {2400,550, 600,600, 1200,550, 650,550, 1200,600, 1200,550, 1250,550, 600,550, 650,550, 1250,550, 600,600, 1200,550, 1250,550, 600,600, 1200,550, 650,550, 600,600, 600,550, 1250,550, 1200,600, 1200};
          IrSender.sendRaw(MABBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /D"))    //Mover Izquierda
        {
          unsigned int MIBRRawData[41] = {2400,550, 1250,550, 1200,600, 600,550, 1250,550, 1200,600, 1200,550, 650,550, 600,600, 1200,550, 650,550, 1200,600, 1200,550, 650,550, 1200,600, 600,550, 650,550, 650,550, 1200,550, 1250,550, 1200};
          IrSender.sendRaw(MIBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /E"))    //Mover Derecha
        {
          unsigned int MDBRRawData[41] = {2400,550, 650,550, 600,550, 1250,550, 1250,550, 1200,550, 1250,550, 600,600, 600,550, 1250,550, 650,550, 1200,550, 1250,550, 600,600, 1200,550, 650,550, 650,550, 600,550, 1250,550, 1250,550, 1200};
          IrSender.sendRaw(MDBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /F"))    //Boton Seleccionar
        {
          unsigned int BSBRRawData[41] = {2400,600, 1200,550, 650,550, 1200,550, 1250,550, 1250,550, 1200,550, 650,550, 650,550, 1200,550, 650,550, 1250,550, 1200,550, 650,550, 1250,550, 600,550, 650,550, 650,550, 1200,550, 1250,550, 1250};
          IrSender.sendRaw(BSBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /I"))    //Play
        {
          unsigned int PlayBRRawData[41] = {2400,550, 650,550, 1200,550, 650,550, 1250,550, 1200,550, 650,550, 650,550, 650,550, 1200,550, 650,550, 1200,600, 1200,550, 650,550, 1200,600, 600,550, 650,550, 650,550, 1200,550, 1250,550, 1200};
          IrSender.sendRaw(PlayBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /J"))    //Pausa
        {
          unsigned int PausaBRRawData[41] = {2450,550, 1200,550, 650,550, 650,550, 1200,600, 1200,550, 650,550, 600,600, 600,550, 1250,550, 650,550, 1200,550, 1250,550, 600,600, 1200,550, 650,550, 650,550, 600,550, 1250,550, 1250,550, 1200};
          IrSender.sendRaw(PausaBRRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /K"))    //Atrasar
        {
          unsigned int BAtraRawData[41] = {2500,600, 1250,550, 1250,600, 600,600, 1200,650, 1200,600, 700,550, 600,650, 600,650, 1200,650, 600,600, 1250,550, 1200,650, 700,550, 1250,600, 650,550, 600,650, 650,600, 1250,600, 1250,600, 1200};  // Protocol=SONY Data=0xD8B47
          IrSender.sendRaw(BAtraRawData, 41, 38);

          Serial.println("Signal sended\n");
        }

        if (currentLine.endsWith("GET /M"))    //Adelantar
        {
          unsigned int BAdeRawData[41] = {2450,600, 650,550, 650,600, 1250,600, 1250,550, 1250,600, 650,550, 650,600, 650,600, 1250,550, 550,700, 1150,650, 1200,650, 650,550, 1250,600, 600,600, 700,550, 650,600, 1250,550, 1200,650, 1200};  // Protocol=UNKNOWN Data=0x41F5FD5B
          IrSender.sendRaw(BAdeRawData, 41, 38);

          Serial.println("Signal sended\n");
        }
      }
    }
  }
}
