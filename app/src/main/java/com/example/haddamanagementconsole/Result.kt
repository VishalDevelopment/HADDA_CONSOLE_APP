package com.example.haddamanagementconsole

import android.os.Message

sealed class Result <T>(val data:T , val message: String?){

}