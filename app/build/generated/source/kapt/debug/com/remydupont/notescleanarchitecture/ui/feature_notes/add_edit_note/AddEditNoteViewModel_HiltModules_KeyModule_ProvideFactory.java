// Generated by Dagger (https://dagger.dev).
package com.remydupont.notescleanarchitecture.ui.feature_notes.add_edit_note;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AddEditNoteViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static AddEditNoteViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(AddEditNoteViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final AddEditNoteViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AddEditNoteViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}