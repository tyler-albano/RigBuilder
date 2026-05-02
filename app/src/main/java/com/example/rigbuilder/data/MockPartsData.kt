package com.example.rigbuilder.data

object MockPartsData {

    val parts = listOf(

        // CPUs
        PCPart(1, "Ryzen 7 5800X", "CPU", "AMD", 299.99, "8 cores, AM4 socket", "AM4"),
        PCPart(2, "Ryzen 9 5900X", "CPU", "AMD", 399.99, "12 cores, AM4 socket", "AM4"),
        PCPart(3, "Intel i7-12700K", "CPU", "Intel", 349.99, "12 cores, LGA1700", "LGA1700"),
        PCPart(4, "Intel i5-12600K", "CPU", "Intel", 269.99, "10 cores, LGA1700", "LGA1700"),

        // GPUs
        PCPart(5, "RTX 4070", "GPU", "NVIDIA", 599.99, "12GB GDDR6X"),
        PCPart(6, "RTX 4060 Ti", "GPU", "NVIDIA", 499.99, "8GB GDDR6"),
        PCPart(7, "RX 7800 XT", "GPU", "AMD", 549.99, "16GB GDDR6"),
        PCPart(8, "RX 7700 XT", "GPU", "AMD", 449.99, "12GB GDDR6"),

        // RAM
        PCPart(9, "Corsair Vengeance 16GB", "RAM", "Corsair", 79.99, "DDR4 3200MHz"),
        PCPart(10, "G.Skill Trident Z 32GB", "RAM", "G.Skill", 149.99, "DDR4 3600MHz"),
        PCPart(11, "Kingston Fury 16GB", "RAM", "Kingston", 69.99, "DDR4 3000MHz"),

        // Storage
        PCPart(12, "Samsung 970 EVO 1TB", "Storage", "Samsung", 89.99, "NVMe SSD"),
        PCPart(13, "WD Black SN850 1TB", "Storage", "Western Digital", 129.99, "NVMe SSD"),
        PCPart(14, "Crucial MX500 1TB", "Storage", "Crucial", 79.99, "SATA SSD"),

        // Motherboards
        PCPart(15, "MSI B550 Tomahawk", "Motherboard", "MSI", 179.99, "AM4, ATX", "AM4"),
        PCPart(16, "ASUS ROG Strix B650", "Motherboard", "ASUS", 229.99, "AM5, ATX", "AM5"),
        PCPart(17, "Gigabyte Z690 Aorus", "Motherboard", "Gigabyte", 249.99, "LGA1700", "LGA1700"),

        // Power Supplies
        PCPart(18, "Corsair RM750e", "PSU", "Corsair", 109.99, "750W, 80+ Gold"),
        PCPart(19, "EVGA 650W Bronze", "PSU", "EVGA", 79.99, "650W, 80+ Bronze"),
        PCPart(20, "Seasonic Focus 850W", "PSU", "Seasonic", 129.99, "850W, 80+ Gold")
    )
}