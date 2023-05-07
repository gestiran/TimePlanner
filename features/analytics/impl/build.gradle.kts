plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
    maven(url = "https://jitpack.i")
}

android {
    namespace = "ru.aleshin.features.analytics.impl"
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion

        testInstrumentationRunner = Config.testInstrumentRunner
        consumerProguardFiles(Config.consumerProguardFiles)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompiler
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":module-injector"))
    implementation(project(":core:utils"))
    implementation(project(":core:ui"))
    implementation(project(":features:home:api"))
    implementation(project(":features:analytics:api"))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.lifecycleRuntime)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.placeHolder)

    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.layout)

    implementation(Dependencies.Charts.library)
    implementation("com.himanshoe:charty:1.0.1")

    implementation(Dependencies.Dagger.core)
    kapt(Dependencies.Dagger.kapt)

    implementation(Dependencies.Voyager.navigator)
    implementation(Dependencies.Voyager.screenModel)

    testImplementation(Dependencies.Test.jUnit)
    testImplementation(Dependencies.Test.turbine)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    androidTestImplementation(Dependencies.Test.composeJUnit)
    debugImplementation(Dependencies.Compose.uiTooling)
    debugImplementation(Dependencies.Compose.uiTestManifest)
}