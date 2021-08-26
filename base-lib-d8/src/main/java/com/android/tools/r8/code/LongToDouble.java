// Copyright (c) 2016, the R8 project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package com.android.tools.r8.code;

import com.android.tools.r8.ir.code.NumericType;
import com.android.tools.r8.ir.conversion.IRBuilder;
public class LongToDouble extends Format12x {

  public static final int OPCODE = 0x86;
  public static final String NAME = "LongToDouble";
  public static final String SMALI_NAME = "long-to-double";

  LongToDouble(int high, BytecodeStream stream) {
    super(high, stream);
  }

  public LongToDouble(int dest, int source) {
    super(dest, source);
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public String getSmaliName() {
    return SMALI_NAME;
  }

  @Override
  public int getOpcode() {
    return OPCODE;
  }

  @Override
  public void buildIR(IRBuilder builder) {
    builder.addConversion(NumericType.DOUBLE, NumericType.LONG, A, B);
  }
}