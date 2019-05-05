package com.example.a777.simpletextfilewriter

class TextFileImpl: TextFile {
    override fun getFileName(): String {
        val date1 = System.currentTimeMillis()
        val fileName = "${date1.toString()}.txt"
        return fileName
    }
}