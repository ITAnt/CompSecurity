.class public Lorg/spongycastle/jcajce/provider/digest/GOST3411$Digest;
.super Lorg/spongycastle/jcajce/provider/digest/BCMessageDigest;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Cloneable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/spongycastle/jcajce/provider/digest/GOST3411;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Digest"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Lorg/spongycastle/crypto/digests/GOST3411Digest;

    invoke-direct {v0}, Lorg/spongycastle/crypto/digests/GOST3411Digest;-><init>()V

    invoke-direct {p0, v0}, Lorg/spongycastle/jcajce/provider/digest/BCMessageDigest;-><init>(Lorg/spongycastle/crypto/Digest;)V

    .line 20
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 3

    .prologue
    .line 25
    invoke-super {p0}, Lorg/spongycastle/jcajce/provider/digest/BCMessageDigest;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/spongycastle/jcajce/provider/digest/GOST3411$Digest;

    .line 26
    new-instance v2, Lorg/spongycastle/crypto/digests/GOST3411Digest;

    iget-object v1, p0, Lorg/spongycastle/jcajce/provider/digest/GOST3411$Digest;->a:Lorg/spongycastle/crypto/Digest;

    check-cast v1, Lorg/spongycastle/crypto/digests/GOST3411Digest;

    invoke-direct {v2, v1}, Lorg/spongycastle/crypto/digests/GOST3411Digest;-><init>(Lorg/spongycastle/crypto/digests/GOST3411Digest;)V

    iput-object v2, v0, Lorg/spongycastle/jcajce/provider/digest/GOST3411$Digest;->a:Lorg/spongycastle/crypto/Digest;

    .line 28
    return-object v0
.end method
