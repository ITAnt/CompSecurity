.class public final Lcom/c/b/i$ac$a;
.super Lcom/c/b/as$c;
.source "SourceFile"

# interfaces
.implements Lcom/c/b/i$ad;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/c/b/i$ac;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field private a:I

.field private b:Z

.field private c:Ljava/util/List;

.field private d:Lcom/c/b/bn;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 25107
    invoke-direct {p0}, Lcom/c/b/as$c;-><init>()V

    .line 25310
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    .line 25108
    invoke-direct {p0}, Lcom/c/b/i$ac$a;->s()V

    .line 25109
    return-void
.end method

.method synthetic constructor <init>(B)V
    .locals 0

    .prologue
    .line 25089
    invoke-direct {p0}, Lcom/c/b/i$ac$a;-><init>()V

    return-void
.end method

.method private constructor <init>(Lcom/c/b/as$b;)V
    .locals 1

    .prologue
    .line 25113
    invoke-direct {p0, p1}, Lcom/c/b/as$c;-><init>(Lcom/c/b/as$b;)V

    .line 25310
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    .line 25114
    invoke-direct {p0}, Lcom/c/b/i$ac$a;->s()V

    .line 25115
    return-void
.end method

.method synthetic constructor <init>(Lcom/c/b/as$b;B)V
    .locals 0

    .prologue
    .line 25089
    invoke-direct {p0, p1}, Lcom/c/b/i$ac$a;-><init>(Lcom/c/b/as$b;)V

    return-void
.end method

.method private d(Lcom/c/b/bd;)Lcom/c/b/i$ac$a;
    .locals 1

    .prologue
    .line 25174
    instance-of v0, p1, Lcom/c/b/i$ac;

    if-eqz v0, :cond_0

    .line 25175
    check-cast p1, Lcom/c/b/i$ac;

    invoke-virtual {p0, p1}, Lcom/c/b/i$ac$a;->a(Lcom/c/b/i$ac;)Lcom/c/b/i$ac$a;

    move-result-object p0

    .line 25178
    :goto_0
    return-object p0

    .line 25177
    :cond_0
    invoke-super {p0, p1}, Lcom/c/b/as$c;->a(Lcom/c/b/bd;)Lcom/c/b/a$a;

    goto :goto_0
.end method

.method private d(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/i$ac$a;
    .locals 4

    .prologue
    .line 25235
    const/4 v2, 0x0

    .line 25237
    :try_start_0
    sget-object v0, Lcom/c/b/i$ac;->c:Lcom/c/b/bk;

    invoke-interface {v0, p1, p2}, Lcom/c/b/bk;->a(Lcom/c/b/g;Lcom/c/b/aq;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/c/b/i$ac;
    :try_end_0
    .catch Lcom/c/b/av; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 25242
    if-eqz v0, :cond_0

    .line 25243
    invoke-virtual {p0, v0}, Lcom/c/b/i$ac$a;->a(Lcom/c/b/i$ac;)Lcom/c/b/i$ac$a;

    .line 25246
    :cond_0
    return-object p0

    .line 25238
    :catch_0
    move-exception v0

    move-object v1, v0

    .line 25239
    :try_start_1
    invoke-virtual {v1}, Lcom/c/b/av;->a()Lcom/c/b/be;

    move-result-object v0

    check-cast v0, Lcom/c/b/i$ac;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 25240
    :try_start_2
    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 25242
    :catchall_0
    move-exception v1

    move-object v3, v1

    move-object v1, v0

    move-object v0, v3

    :goto_0
    if-eqz v1, :cond_1

    .line 25243
    invoke-virtual {p0, v1}, Lcom/c/b/i$ac$a;->a(Lcom/c/b/i$ac;)Lcom/c/b/i$ac$a;

    .line 25242
    :cond_1
    throw v0

    :catchall_1
    move-exception v0

    move-object v1, v2

    goto :goto_0
.end method

.method private s()V
    .locals 1

    .prologue
    .line 25117
    sget-boolean v0, Lcom/c/b/as;->d:Z

    if-eqz v0, :cond_0

    .line 25118
    invoke-direct {p0}, Lcom/c/b/i$ac$a;->u()Lcom/c/b/bn;

    .line 25120
    :cond_0
    return-void
.end method

.method private t()Lcom/c/b/i$ac;
    .locals 2

    .prologue
    .line 25144
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->g()Lcom/c/b/i$ac;

    move-result-object v0

    .line 25145
    invoke-virtual {v0}, Lcom/c/b/i$ac;->a()Z

    move-result v1

    if-nez v1, :cond_0

    .line 25146
    invoke-static {v0}, Lcom/c/b/i$ac$a;->b(Lcom/c/b/bd;)Lcom/c/b/bx;

    move-result-object v0

    throw v0

    .line 25148
    :cond_0
    return-object v0
.end method

.method private u()Lcom/c/b/bn;
    .locals 5

    .prologue
    .line 25610
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    if-nez v0, :cond_0

    .line 25611
    new-instance v1, Lcom/c/b/bn;

    iget-object v2, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    iget v0, p0, Lcom/c/b/i$ac$a;->a:I

    and-int/lit8 v0, v0, 0x2

    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->p()Lcom/c/b/as$b;

    move-result-object v3

    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->n()Z

    move-result v4

    invoke-direct {v1, v2, v0, v3, v4}, Lcom/c/b/bn;-><init>(Ljava/util/List;ZLcom/c/b/as$b;Z)V

    iput-object v1, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    .line 25617
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    .line 25619
    :cond_0
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    return-object v0

    .line 25611
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final synthetic a(Lcom/c/b/bd;)Lcom/c/b/a$a;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0, p1}, Lcom/c/b/i$ac$a;->d(Lcom/c/b/bd;)Lcom/c/b/i$ac$a;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic a(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/a$a;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0, p1, p2}, Lcom/c/b/i$ac$a;->d(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/i$ac$a;

    move-result-object v0

    return-object v0
.end method

.method public final a(Lcom/c/b/i$ac;)Lcom/c/b/i$ac$a;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 25183
    invoke-static {}, Lcom/c/b/i$ac;->k()Lcom/c/b/i$ac;

    move-result-object v1

    if-ne p1, v1, :cond_0

    .line 25216
    :goto_0
    return-object p0

    .line 25184
    :cond_0
    invoke-virtual {p1}, Lcom/c/b/i$ac;->h()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 25185
    invoke-virtual {p1}, Lcom/c/b/i$ac;->i()Z

    move-result v1

    iget v2, p0, Lcom/c/b/i$ac$a;->a:I

    or-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/c/b/i$ac$a;->a:I

    iput-boolean v1, p0, Lcom/c/b/i$ac$a;->b:Z

    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->q()V

    .line 25187
    :cond_1
    iget-object v1, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    if-nez v1, :cond_5

    .line 25188
    invoke-static {p1}, Lcom/c/b/i$ac;->b(Lcom/c/b/i$ac;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 25189
    iget-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 25190
    invoke-static {p1}, Lcom/c/b/i$ac;->b(Lcom/c/b/i$ac;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    .line 25191
    iget v0, p0, Lcom/c/b/i$ac$a;->a:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/c/b/i$ac$a;->a:I

    .line 25196
    :goto_1
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->q()V

    .line 25213
    :cond_2
    :goto_2
    invoke-virtual {p0, p1}, Lcom/c/b/i$ac$a;->a(Lcom/c/b/as$d;)V

    .line 25214
    iget-object v0, p1, Lcom/c/b/i$ac;->e:Lcom/c/b/by;

    invoke-virtual {p0, v0}, Lcom/c/b/i$ac$a;->d(Lcom/c/b/by;)Lcom/c/b/as$a;

    .line 25215
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->q()V

    goto :goto_0

    .line 25193
    :cond_3
    iget v0, p0, Lcom/c/b/i$ac$a;->a:I

    and-int/lit8 v0, v0, 0x2

    const/4 v1, 0x2

    if-eq v0, v1, :cond_4

    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    iget v0, p0, Lcom/c/b/i$ac$a;->a:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/c/b/i$ac$a;->a:I

    .line 25194
    :cond_4
    iget-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-static {p1}, Lcom/c/b/i$ac;->b(Lcom/c/b/i$ac;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_1

    .line 25199
    :cond_5
    invoke-static {p1}, Lcom/c/b/i$ac;->b(Lcom/c/b/i$ac;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 25200
    iget-object v1, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    invoke-virtual {v1}, Lcom/c/b/bn;->d()Z

    move-result v1

    if-eqz v1, :cond_7

    .line 25201
    iget-object v1, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    invoke-virtual {v1}, Lcom/c/b/bn;->b()V

    .line 25202
    iput-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    .line 25203
    invoke-static {p1}, Lcom/c/b/i$ac;->b(Lcom/c/b/i$ac;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    .line 25204
    iget v1, p0, Lcom/c/b/i$ac$a;->a:I

    and-int/lit8 v1, v1, -0x3

    iput v1, p0, Lcom/c/b/i$ac$a;->a:I

    .line 25205
    sget-boolean v1, Lcom/c/b/as;->d:Z

    if-eqz v1, :cond_6

    invoke-direct {p0}, Lcom/c/b/i$ac$a;->u()Lcom/c/b/bn;

    move-result-object v0

    :cond_6
    iput-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    goto :goto_2

    .line 25209
    :cond_7
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    invoke-static {p1}, Lcom/c/b/i$ac;->b(Lcom/c/b/i$ac;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/c/b/bn;->a(Ljava/lang/Iterable;)Lcom/c/b/bn;

    goto :goto_2
.end method

.method public final a()Z
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 25220
    move v1, v2

    :goto_0
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_1
    if-ge v1, v0, :cond_4

    .line 25221
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/c/b/i$ag;

    :goto_2
    invoke-virtual {v0}, Lcom/c/b/i$ag;->a()Z

    move-result v0

    if-nez v0, :cond_3

    .line 25228
    :cond_0
    :goto_3
    return v2

    .line 25220
    :cond_1
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    invoke-virtual {v0}, Lcom/c/b/bn;->c()I

    move-result v0

    goto :goto_1

    .line 25221
    :cond_2
    iget-object v0, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    invoke-virtual {v0, v1}, Lcom/c/b/bn;->a(I)Lcom/c/b/as;

    move-result-object v0

    check-cast v0, Lcom/c/b/i$ag;

    goto :goto_2

    .line 25220
    :cond_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 25225
    :cond_4
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->r()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 25228
    const/4 v2, 0x1

    goto :goto_3
.end method

.method public final synthetic b(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/b$a;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0, p1, p2}, Lcom/c/b/i$ac$a;->d(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/i$ac$a;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic c(Lcom/c/b/bd;)Lcom/c/b/bd$a;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0, p1}, Lcom/c/b/i$ac$a;->d(Lcom/c/b/bd;)Lcom/c/b/i$ac$a;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic c(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/be$a;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0, p1, p2}, Lcom/c/b/i$ac$a;->d(Lcom/c/b/g;Lcom/c/b/aq;)Lcom/c/b/i$ac$a;

    move-result-object v0

    return-object v0
.end method

.method protected final d()Lcom/c/b/as$g;
    .locals 3

    .prologue
    .line 25101
    invoke-static {}, Lcom/c/b/i;->G()Lcom/c/b/as$g;

    move-result-object v0

    const-class v1, Lcom/c/b/i$ac;

    const-class v2, Lcom/c/b/i$ac$a;

    invoke-virtual {v0, v1, v2}, Lcom/c/b/as$g;->a(Ljava/lang/Class;Ljava/lang/Class;)Lcom/c/b/as$g;

    move-result-object v0

    return-object v0
.end method

.method public final e()Lcom/c/b/ak$a;
    .locals 1

    .prologue
    .line 25136
    invoke-static {}, Lcom/c/b/i;->F()Lcom/c/b/ak$a;

    move-result-object v0

    return-object v0
.end method

.method public final g()Lcom/c/b/i$ac;
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 25152
    new-instance v2, Lcom/c/b/i$ac;

    invoke-direct {v2, p0, v1}, Lcom/c/b/i$ac;-><init>(Lcom/c/b/as$c;B)V

    .line 25153
    iget v3, p0, Lcom/c/b/i$ac$a;->a:I

    .line 25155
    and-int/lit8 v3, v3, 0x1

    if-ne v3, v0, :cond_2

    .line 25158
    :goto_0
    iget-boolean v1, p0, Lcom/c/b/i$ac$a;->b:Z

    invoke-static {v2, v1}, Lcom/c/b/i$ac;->a(Lcom/c/b/i$ac;Z)Z

    .line 25159
    iget-object v1, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    if-nez v1, :cond_1

    .line 25160
    iget v1, p0, Lcom/c/b/i$ac$a;->a:I

    and-int/lit8 v1, v1, 0x2

    const/4 v3, 0x2

    if-ne v1, v3, :cond_0

    .line 25161
    iget-object v1, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    .line 25162
    iget v1, p0, Lcom/c/b/i$ac$a;->a:I

    and-int/lit8 v1, v1, -0x3

    iput v1, p0, Lcom/c/b/i$ac$a;->a:I

    .line 25164
    :cond_0
    iget-object v1, p0, Lcom/c/b/i$ac$a;->c:Ljava/util/List;

    invoke-static {v2, v1}, Lcom/c/b/i$ac;->a(Lcom/c/b/i$ac;Ljava/util/List;)Ljava/util/List;

    .line 25168
    :goto_1
    invoke-static {v2, v0}, Lcom/c/b/i$ac;->a(Lcom/c/b/i$ac;I)I

    .line 25169
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->l()V

    .line 25170
    return-object v2

    .line 25166
    :cond_1
    iget-object v1, p0, Lcom/c/b/i$ac$a;->d:Lcom/c/b/bn;

    invoke-virtual {v1}, Lcom/c/b/bn;->e()Ljava/util/List;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/c/b/i$ac;->a(Lcom/c/b/i$ac;Ljava/util/List;)Ljava/util/List;

    goto :goto_1

    :cond_2
    move v0, v1

    goto :goto_0
.end method

.method public final synthetic h()Lcom/c/b/bd;
    .locals 1

    .prologue
    .line 25089
    invoke-virtual {p0}, Lcom/c/b/i$ac$a;->g()Lcom/c/b/i$ac;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic i()Lcom/c/b/bd;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0}, Lcom/c/b/i$ac$a;->t()Lcom/c/b/i$ac;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic j()Lcom/c/b/be;
    .locals 1

    .prologue
    .line 25089
    invoke-direct {p0}, Lcom/c/b/i$ac$a;->t()Lcom/c/b/i$ac;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic w()Lcom/c/b/bd;
    .locals 1

    .prologue
    .line 25089
    invoke-static {}, Lcom/c/b/i$ac;->k()Lcom/c/b/i$ac;

    move-result-object v0

    return-object v0
.end method
