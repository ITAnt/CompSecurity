.class public final Lcrittercism/android/az$1;
.super Lcrittercism/android/di;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcrittercism/android/az;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcrittercism/android/az;


# direct methods
.method public constructor <init>(Lcrittercism/android/az;)V
    .locals 0

    .prologue
    .line 566
    iput-object p1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    invoke-direct {p0}, Lcrittercism/android/di;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 568
    iget-object v0, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v0, v0, Lcrittercism/android/az;->f:Lcrittercism/android/dw;

    invoke-virtual {v0}, Lcrittercism/android/dw;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 608
    :goto_0
    return-void

    .line 570
    :cond_0
    new-instance v0, Lcrittercism/android/df;

    iget-object v1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v1, v1, Lcrittercism/android/az;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcrittercism/android/df;-><init>(Landroid/content/Context;)V

    .line 571
    iget-object v1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v1, v1, Lcrittercism/android/az;->g:Lcrittercism/android/br;

    new-instance v2, Lcrittercism/android/ct$a;

    invoke-direct {v2}, Lcrittercism/android/ct$a;-><init>()V

    iget-object v3, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v3, v3, Lcrittercism/android/az;->v:Lcrittercism/android/bb;

    invoke-virtual {v3}, Lcrittercism/android/bb;->e()Ljava/lang/String;

    move-result-object v3

    const-string v4, "/v0/appload/"

    iget-object v5, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v5, v5, Lcrittercism/android/az;->v:Lcrittercism/android/bb;

    invoke-virtual {v5}, Lcrittercism/android/bb;->b()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcrittercism/android/az;->a:Lcrittercism/android/az;

    new-instance v7, Lcrittercism/android/cs$b;

    invoke-direct {v7}, Lcrittercism/android/cs$b;-><init>()V

    invoke-virtual/range {v0 .. v7}, Lcrittercism/android/df;->a(Lcrittercism/android/br;Lcrittercism/android/cz;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcrittercism/android/au;Lcrittercism/android/cx;)V

    .line 580
    iget-object v1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v1, v1, Lcrittercism/android/az;->h:Lcrittercism/android/br;

    new-instance v2, Lcrittercism/android/da$a;

    invoke-direct {v2}, Lcrittercism/android/da$a;-><init>()V

    iget-object v3, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v3, v3, Lcrittercism/android/az;->v:Lcrittercism/android/bb;

    invoke-virtual {v3}, Lcrittercism/android/bb;->b()Ljava/lang/String;

    move-result-object v3

    const-string v4, "/android_v2/handle_exceptions"

    sget-object v6, Lcrittercism/android/az;->a:Lcrittercism/android/az;

    new-instance v7, Lcrittercism/android/cu$a;

    invoke-direct {v7}, Lcrittercism/android/cu$a;-><init>()V

    move-object v5, v8

    invoke-virtual/range {v0 .. v7}, Lcrittercism/android/df;->a(Lcrittercism/android/br;Lcrittercism/android/cz;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcrittercism/android/au;Lcrittercism/android/cx;)V

    .line 589
    iget-object v1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v1, v1, Lcrittercism/android/az;->i:Lcrittercism/android/br;

    new-instance v2, Lcrittercism/android/da$a;

    invoke-direct {v2}, Lcrittercism/android/da$a;-><init>()V

    iget-object v3, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v3, v3, Lcrittercism/android/az;->v:Lcrittercism/android/bb;

    invoke-virtual {v3}, Lcrittercism/android/bb;->b()Ljava/lang/String;

    move-result-object v3

    const-string v4, "/android_v2/handle_ndk_crashes"

    sget-object v6, Lcrittercism/android/az;->a:Lcrittercism/android/az;

    new-instance v7, Lcrittercism/android/cu$a;

    invoke-direct {v7}, Lcrittercism/android/cu$a;-><init>()V

    move-object v5, v8

    invoke-virtual/range {v0 .. v7}, Lcrittercism/android/df;->a(Lcrittercism/android/br;Lcrittercism/android/cz;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcrittercism/android/au;Lcrittercism/android/cx;)V

    .line 598
    iget-object v1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v1, v1, Lcrittercism/android/az;->j:Lcrittercism/android/br;

    new-instance v2, Lcrittercism/android/da$a;

    invoke-direct {v2}, Lcrittercism/android/da$a;-><init>()V

    iget-object v3, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v3, v3, Lcrittercism/android/az;->v:Lcrittercism/android/bb;

    invoke-virtual {v3}, Lcrittercism/android/bb;->b()Ljava/lang/String;

    move-result-object v3

    const-string v4, "/android_v2/handle_crashes"

    sget-object v6, Lcrittercism/android/az;->a:Lcrittercism/android/az;

    new-instance v7, Lcrittercism/android/cu$a;

    invoke-direct {v7}, Lcrittercism/android/cu$a;-><init>()V

    move-object v5, v8

    invoke-virtual/range {v0 .. v7}, Lcrittercism/android/df;->a(Lcrittercism/android/br;Lcrittercism/android/cz;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcrittercism/android/au;Lcrittercism/android/cx;)V

    .line 607
    iget-object v1, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v1, v1, Lcrittercism/android/az;->r:Lcrittercism/android/dg;

    iget-object v2, p0, Lcrittercism/android/az$1;->a:Lcrittercism/android/az;

    iget-object v2, v2, Lcrittercism/android/az;->s:Ljava/util/concurrent/ExecutorService;

    invoke-virtual {v0, v1, v2}, Lcrittercism/android/df;->a(Lcrittercism/android/dg;Ljava/util/concurrent/ExecutorService;)V

    goto/16 :goto_0
.end method
