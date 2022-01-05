package com.github.pemistahl.lingua.app
import com.github.pemistahl.lingua.api.IsoCode639_1
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder.Companion.fromAllLanguages
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder.Companion.fromIsoCodes639_1
import java.io.Console
import java.util.Scanner


fun main(args: Array<String>) {

    if (args.size == 2) {

        val isoCodesList = mutableListOf<String>()
        isoCodesList.addAll(args[0].split(Regex("\\s+")))
    
        val isoCodes = mutableListOf<IsoCode639_1>()
    
        for (isoCode in isoCodesList) {
            isoCodes.add(IsoCode639_1.valueOf(isoCode.uppercase()))
        }
    
        var detectorBuilder: LanguageDetectorBuilder? = null
        
        isoCodes.add(IsoCode639_1.EN)
        isoCodes.add(IsoCode639_1.valueOf("IT"))
        detectorBuilder = fromIsoCodes639_1(*isoCodes.toTypedArray())
        val detector = detectorBuilder.build()
        println(detector.detectLanguageOf(args[1]))
       

    } else {
        println("Param 1: List of ISO639-1 codes, param2: Text")
    }

    System.exit(1);



}