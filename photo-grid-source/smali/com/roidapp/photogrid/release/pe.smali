.class final Lcom/roidapp/photogrid/release/pe;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/roidapp/photogrid/release/ie;

.field final synthetic b:Lcom/roidapp/photogrid/release/pd;


# direct methods
.method constructor <init>(Lcom/roidapp/photogrid/release/pd;Lcom/roidapp/photogrid/release/ie;)V
    .locals 0

    .prologue
    .line 92
    iput-object p1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iput-object p2, p0, Lcom/roidapp/photogrid/release/pe;->a:Lcom/roidapp/photogrid/release/ie;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 6

    .prologue
    const/16 v5, 0x800

    const/16 v4, 0x438

    const/4 v3, 0x0

    .line 97
    :try_start_0
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->a:Lcom/roidapp/photogrid/release/ie;

    .line 1284
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/roidapp/photogrid/release/ie;->c(Z)[Ljava/lang/String;

    move-result-object v0

    .line 98
    if-eqz v0, :cond_6

    .line 99
    const/4 v1, 0x0

    aget-object v1, v0, v1

    if-eqz v1, :cond_3

    const/4 v1, 0x0

    aget-object v1, v0, v1

    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 100
    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/4 v2, 0x1

    aget-object v0, v0, v2

    iput-object v0, v1, Lcom/roidapp/photogrid/release/pd;->e:Ljava/lang/String;

    .line 101
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->e:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->e:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 102
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->d:Lcom/roidapp/photogrid/release/ml;

    const/16 v1, 0x5f

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/roidapp/photogrid/release/ml;->a(II)V

    .line 103
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, v1, Lcom/roidapp/photogrid/release/pd;->b:Landroid/app/Activity;

    iget-object v2, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v2, v2, Lcom/roidapp/photogrid/release/pd;->e:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/roidapp/photogrid/release/pd;->a(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 171
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    if-eqz v0, :cond_1

    .line 172
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    iput-boolean v3, v0, Lcom/roidapp/photogrid/release/PhotoView;->a:Z

    .line 175
    :cond_1
    :goto_1
    return-void

    .line 105
    :cond_2
    :try_start_1
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    .line 106
    const/4 v1, 0x7

    iput v1, v0, Landroid/os/Message;->what:I

    .line 107
    const/16 v1, 0x90

    iput v1, v0, Landroid/os/Message;->arg1:I

    .line 108
    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, v1, Lcom/roidapp/photogrid/release/pd;->d:Lcom/roidapp/photogrid/release/ml;

    invoke-virtual {v1, v0}, Lcom/roidapp/photogrid/release/ml;->sendMessage(Landroid/os/Message;)Z
    :try_end_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 129
    :catch_0
    move-exception v0

    :try_start_2
    invoke-virtual {v0}, Ljava/lang/OutOfMemoryError;->printStackTrace()V

    .line 130
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 131
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 132
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    const/16 v1, 0x1e0

    if-ne v0, v1, :cond_7

    .line 133
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x140

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 134
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 171
    :goto_2
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    if-eqz v0, :cond_1

    .line 172
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    iput-boolean v3, v0, Lcom/roidapp/photogrid/release/PhotoView;->a:Z

    goto :goto_1

    .line 110
    :cond_3
    const/4 v1, 0x0

    :try_start_3
    aget-object v1, v0, v1

    if-eqz v1, :cond_4

    const/4 v1, 0x0

    aget-object v1, v0, v1

    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 111
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v1

    .line 112
    const/16 v2, 0x2bc

    iput v2, v1, Landroid/os/Message;->what:I

    .line 113
    const/4 v2, 0x1

    aget-object v0, v0, v2

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 114
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_3
    .catch Ljava/lang/OutOfMemoryError; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 162
    :catch_1
    move-exception v0

    .line 163
    :try_start_4
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 164
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 165
    const-string v2, "No space"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 166
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/16 v1, 0x2be

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 171
    :goto_3
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    if-eqz v0, :cond_1

    .line 172
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    iput-boolean v3, v0, Lcom/roidapp/photogrid/release/PhotoView;->a:Z

    goto/16 :goto_1

    .line 115
    :cond_4
    const/4 v1, 0x0

    :try_start_5
    aget-object v1, v0, v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    aget-object v1, v0, v1

    const-string v2, "2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 116
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v1

    .line 117
    const/16 v2, 0x2bd

    iput v2, v1, Landroid/os/Message;->what:I

    .line 118
    const/4 v2, 0x1

    aget-object v0, v0, v2

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 119
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_5
    .catch Ljava/lang/OutOfMemoryError; {:try_start_5 .. :try_end_5} :catch_0
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_0

    .line 171
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, v1, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    if-eqz v1, :cond_5

    .line 172
    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, v1, Lcom/roidapp/photogrid/release/pd;->g:Lcom/roidapp/photogrid/release/PhotoView;

    iput-boolean v3, v1, Lcom/roidapp/photogrid/release/PhotoView;->a:Z

    :cond_5
    throw v0

    .line 122
    :cond_6
    :try_start_6
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    .line 123
    const/4 v1, 0x7

    iput v1, v0, Landroid/os/Message;->what:I

    .line 124
    const/16 v1, 0x91

    iput v1, v0, Landroid/os/Message;->arg1:I

    .line 125
    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, v1, Lcom/roidapp/photogrid/release/pd;->d:Lcom/roidapp/photogrid/release/ml;

    invoke-virtual {v1, v0}, Lcom/roidapp/photogrid/release/ml;->sendMessage(Landroid/os/Message;)Z
    :try_end_6
    .catch Ljava/lang/OutOfMemoryError; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_0

    .line 135
    :cond_7
    :try_start_7
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    const/16 v1, 0x21c

    if-ne v0, v1, :cond_8

    .line 136
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x1e0

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 137
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 138
    :cond_8
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    const/16 v1, 0x2d0

    if-ne v0, v1, :cond_9

    .line 139
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x21c

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 140
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 141
    :cond_9
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    const/16 v1, 0x400

    if-ne v0, v1, :cond_a

    .line 142
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x2d0

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 143
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 144
    :cond_a
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    if-ne v0, v4, :cond_b

    .line 145
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x400

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 146
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 147
    :cond_b
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    const/16 v1, 0x67c

    if-ne v0, v1, :cond_c

    .line 148
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x438

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 149
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 150
    :cond_c
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    const/16 v1, 0x780

    if-ne v0, v1, :cond_d

    .line 151
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x438

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 152
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 153
    :cond_d
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    if-ne v0, v5, :cond_e

    .line 154
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x780

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 155
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 156
    :cond_e
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget v0, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    if-le v0, v5, :cond_f

    .line 157
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    const/16 v1, 0x800

    iput v1, v0, Lcom/roidapp/photogrid/release/pd;->f:I

    .line 158
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto/16 :goto_2

    .line 160
    :cond_f
    iget-object v0, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v0, v0, Lcom/roidapp/photogrid/release/pd;->d:Lcom/roidapp/photogrid/release/ml;

    const/16 v1, 0x92

    invoke-virtual {v0, v1}, Lcom/roidapp/photogrid/release/ml;->a(I)V

    goto/16 :goto_2

    .line 168
    :cond_10
    iget-object v1, p0, Lcom/roidapp/photogrid/release/pe;->b:Lcom/roidapp/photogrid/release/pd;

    iget-object v1, v1, Lcom/roidapp/photogrid/release/pd;->q:Landroid/os/Handler;

    invoke-static {v1, v0}, Lcom/roidapp/photogrid/common/c;->a(Landroid/os/Handler;Ljava/lang/Throwable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_3
.end method
