class Sensor:
    tipo = "Genérico"

    def __init__(self, id):
        self.id = id
        self.encendido = False

    def activar(self):
        self.encendido = True
        print(f"Sensor {self.id} activado")

    def desactivar(self):
        self.encendido = False
        print(f"Sensor {self.id} desactivado")

    def __str__(self):
        return f"Tipo: {self.tipo}, ID: {self.id}, Encendido: {self.encendido}"





class Camara(Sensor):
    tipo = "Cámara"

    def __init__(self, id, resolucion):
        super().__init__(id)
        self.resolucion = resolucion

    def __str__(self):
        return f"{super().__str__()}, Resolución: {self.resolucion}"
    




class SensorLuzLaser(Sensor):
    tipo = "Luz Laser"

    def __init__(self, id, alcance):
        super().__init__(id)
        self.alcance = alcance

    def __str__(self):
        return f"{super().__str__()}, Alcance: {self.alcance}"




class VehiculoAutonomo(Sensor):
    tipo = "Vehiculo Autonomo"

    def __init__(self, id, resolucion, alcance):
        super().__init__(id)
        self.camara = Camara(id + "-C", resolucion)
        self.laser = SensorLuzLaser(id + "-L", alcance)

    def __str__(self):
        return (
            f"Tipo: {self.tipo}, ID: {self.id}, "
            f"Encendido: {self.encendido}\n"
            f"{self.camara}\n"
            f"{self.laser}"
        )



def main():
    sensor = Sensor("S001")
    camara = Camara("C001", "1920x1080")
    laser = SensorLuzLaser("L001", 100)
    vehiculo = VehiculoAutonomo("V001", "1920x1080", 100)

    print(sensor)
    sensor.activar()
    print(sensor)

    print("\n", camara)
    camara.activar()
    print(camara)

    print("\n", laser)
    laser.activar()
    print(laser)

    print("\n", vehiculo)
    vehiculo.activar()
    print(vehiculo)
    vehiculo.desactivar()
    print(vehiculo)


if __name__ == "__main__":
    main()