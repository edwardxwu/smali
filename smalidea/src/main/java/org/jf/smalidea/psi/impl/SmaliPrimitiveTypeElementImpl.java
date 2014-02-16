/*
 * Copyright 2012, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jf.smalidea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.smalidea.psi.iface.SmaliTypeElement;

public class SmaliPrimitiveTypeElementImpl extends ASTWrapperPsiElement implements SmaliTypeElement {
    public SmaliPrimitiveTypeElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiType getType() {
        switch (getText().charAt(0)) {
            case 'Z':
                return PsiType.BOOLEAN;
            case 'B':
                return PsiType.BYTE;
            case 'S':
                return PsiType.SHORT;
            case 'C':
                return PsiType.CHAR;
            case 'I':
                return PsiType.INT;
            case 'J':
                return PsiType.LONG;
            case 'F':
                return PsiType.FLOAT;
            case 'D':
                return PsiType.DOUBLE;
            default:
                throw new RuntimeException("Unexpected primitive type");
        }
    }

    @NotNull @Override public PsiAnnotation[] getAnnotations() {
        return new PsiAnnotation[0];
    }

    @Nullable @Override public PsiJavaCodeReferenceElement getInnermostComponentReferenceElement() {
        return null;
    }

    @NotNull @Override public PsiAnnotation[] getApplicableAnnotations() {
        return new PsiAnnotation[0];
    }

    @Nullable @Override public PsiAnnotation findAnnotation(@NotNull @NonNls String qualifiedName) {
        return null;
    }

    @NotNull @Override public PsiAnnotation addAnnotation(@NotNull @NonNls String qualifiedName) {
        throw new UnsupportedOperationException();
    }
}
