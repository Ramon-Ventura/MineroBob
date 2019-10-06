package com.example.minerobob

enum class estadoBob{
    MINA,HOGAR,BANCO,TABNERA
}

class Minero (private val name: String, private var fatiga: Int, private var sed: Int, private var oro: Int,
              private var estado:estadoBob) {
    var banco: Int = 0

    fun bobWork(){
        while (true){
            if (estado==estadoBob.MINA){
                mineWork()
            }
            if (estado == estadoBob.BANCO){
                bankDep()
            }
            if(estado == estadoBob.TABNERA){
                tavern()
            }

            if(estado == estadoBob.HOGAR){
                home()
            }
        }
    }

    private fun mineWork(){
        while(true){
            timeState()
            if (oro ==0  || fatiga == 0){
                println("Minero $name: De regreso a la mina")
            }
            oro ++
            sed ++
            fatiga += 2

            println("Minero $name: Recolectando una pepita de oro. Oro actual $oro")
            if (oro >=3){
                estado = estadoBob.BANCO
                break
            }
            if (sed >=5){
                estado = estadoBob.TABNERA
                break
            }
            if (fatiga == 10){
                estado = estadoBob.HOGAR
                break
            }

        }

    }

    private fun bankDep() {
        timeState()
        println("Minero $name: Me voy de la mina de oro con mis bolsillos llenos")
        println("Minero $name: Voy para el banco, si señor")
        banco += oro
        println("Minero $name: Total de oro depositado $banco")
        oro = 0
        if(fatiga >= 8){
            estado = estadoBob.HOGAR
        }
        else{
            estado = estadoBob.MINA
        }

    }

    private fun tavern(){
        timeState()
        println("Minero $name: Hombre, estoy sediento me dirijo a la taberna")
        sed -= 5
        println("Minero $name: Oh! Esto si que esta muy bueno ha calmado mi sed")
        if(fatiga >= 8){
            estado = estadoBob.HOGAR
        }
        else{
            estado = estadoBob.MINA
            println ("Minero $name: De regreso a la mina")
        }
    }

    private fun home(){
        timeState()
        fatiga = 0
        println("Minero $name: Me siento muy cansado. Ire a descansar")
        println("Minero $name: De camino a mi hogar dulce hogar")
        println("Minero $name: Hogar dulce hogar")
        println("Minero $name: Zzzz")
        estado = estadoBob.MINA
    }

    private fun timeState(){
        Thread.sleep(1000)
    }



    override fun toString(): String {
        return "Nombre: $name \nFatiga: $fatiga\nSed: $sed\nOro: $oro"
    }
}