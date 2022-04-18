plugins {
    id("fabric-loom") version "0.11-SNAPSHOT" apply false

    // https://github.com/Juuxel/LoomQuiltflower
    id("io.github.juuxel.loom-quiltflower") version "1.7.0" apply false

    // https://github.com/ReplayMod/preprocessor
    id("com.replaymod.preprocess") version "0ab22d2"
}

preprocess {
    val mc11404 = createNode("1.14.4", 11404, "yarn")
    val mc11502 = createNode("1.15.2", 11502, "yarn")

    mc11502.link(mc11404)
}
