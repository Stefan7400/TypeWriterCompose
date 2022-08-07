package extensions

import java.awt.FileDialog
import java.util.Objects

fun FileDialog.getCompleteFilePath(): String? {
  if(Objects.isNull(directory) || Objects.isNull(file)){
      return null
  }
    return this.directory + this.file
}